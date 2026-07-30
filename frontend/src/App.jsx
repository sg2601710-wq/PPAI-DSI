import { useEffect, useMemo, useRef, useState } from 'react'
import { consultarUbicacionBolsin } from './services/consultarBolsinService'
import './App.css'

const GOOGLE_MAPS_API_KEY = import.meta.env.VITE_GOOGLE_MAPS_API_KEY
const DEFAULT_CENTER = { lat: -34.6037, lng: -58.3816 }

let googleMapsPromise

function loadGoogleMaps(apiKey) {
  if (window.google?.maps) {
    return Promise.resolve(window.google.maps)
  }

  if (!googleMapsPromise) {
    googleMapsPromise = new Promise((resolve, reject) => {
      const script = document.createElement('script')
      script.src = `https://maps.googleapis.com/maps/api/js?key=${apiKey}`
      script.async = true
      script.defer = true
      script.onload = () => resolve(window.google.maps)
      script.onerror = () => reject(new Error('No se pudo cargar Google Maps'))
      document.head.appendChild(script)
    })
  }

  return googleMapsPromise
}

function calcularCentro(ubicaciones) {
  if (ubicaciones.length === 0) {
    return DEFAULT_CENTER
  }

  const total = ubicaciones.reduce(
    (acumulado, ubicacion) => ({
      lat: acumulado.lat + Number(ubicacion.latitud),
      lng: acumulado.lng + Number(ubicacion.longitud),
    }),
    { lat: 0, lng: 0 },
  )

  return {
    lat: total.lat / ubicaciones.length,
    lng: total.lng / ubicaciones.length,
  }
}

function formatearHora(fechaHora) {
  if (!fechaHora) {
    return '-'
  }

  return new Intl.DateTimeFormat('es-AR', {
    hour: '2-digit',
    minute: '2-digit',
  }).format(new Date(fechaHora))
}

function TrackingMap({ ubicaciones }) {
  const mapRef = useRef(null)
  const googleMapRef = useRef(null)
  const markersRef = useRef([])
  const [mapStatus, setMapStatus] = useState(
    GOOGLE_MAPS_API_KEY ? 'loading' : 'missing-key',
  )

  useEffect(() => {
    if (!GOOGLE_MAPS_API_KEY || !mapRef.current) {
      return
    }

    let mounted = true

    loadGoogleMaps(GOOGLE_MAPS_API_KEY)
      .then((maps) => {
        if (!mounted || !mapRef.current) {
          return
        }

        if (!googleMapRef.current) {
          googleMapRef.current = new maps.Map(mapRef.current, {
            center: calcularCentro(ubicaciones),
            zoom: ubicaciones.length > 1 ? 11 : 12,
            mapTypeControl: false,
            streetViewControl: false,
            fullscreenControl: false,
          })
        }

        setMapStatus('ready')
      })
      .catch(() => {
        if (mounted) {
          setMapStatus('error')
        }
      })

    return () => {
      mounted = false
    }
  }, [ubicaciones])

  useEffect(() => {
    if (!window.google?.maps || !googleMapRef.current) {
      return
    }

    markersRef.current.forEach((marker) => marker.setMap(null))
    markersRef.current = []

    const bounds = new window.google.maps.LatLngBounds()

    ubicaciones.forEach((ubicacion) => {
      const position = {
        lat: Number(ubicacion.latitud),
        lng: Number(ubicacion.longitud),
      }

      const marker = new window.google.maps.Marker({
        position,
        map: googleMapRef.current,
        label: String(ubicacion.numeroBolsin),
        title: `Bolsin ${ubicacion.numeroBolsin}`,
      })

      markersRef.current.push(marker)
      bounds.extend(position)
    })

    if (ubicaciones.length === 1) {
      googleMapRef.current.setCenter(bounds.getCenter())
      googleMapRef.current.setZoom(12)
    } else if (ubicaciones.length > 1) {
      googleMapRef.current.fitBounds(bounds, 80)
    } else {
      googleMapRef.current.setCenter(DEFAULT_CENTER)
      googleMapRef.current.setZoom(11)
    }
  }, [ubicaciones])

  return (
    <section className="map-shell" aria-label="Mapa de seguimiento">
      <div ref={mapRef} className="google-map" />
      {mapStatus !== 'ready' && (
        <div className="map-state">
          {mapStatus === 'loading' && 'Cargando mapa...'}
          {mapStatus === 'missing-key' && 'Mapa no disponible'}
          {mapStatus === 'error' && 'No se pudo cargar el mapa'}
        </div>
      )}
    </section>
  )
}

function App() {
  const [comisionMedica, setComisionMedica] = useState(null)
  const [ubicacionesBolsines, setUbicacionesBolsines] = useState([])
  const [estadoConsulta, setEstadoConsulta] = useState('cargando')
  const [precinto, setPrecinto] = useState('')
  const [destino, setDestino] = useState('todos')

  useEffect(() => {
    consultarUbicacionBolsin()
      .then((respuesta) => {
        setComisionMedica(respuesta.comisionMedicaUsuarioLogueado)
        setUbicacionesBolsines(respuesta.ubicacionesBolsines ?? [])
        setEstadoConsulta('lista')
      })
      .catch(() => {
        setEstadoConsulta('error')
      })
  }, [])

  const destinos = useMemo(() => {
    return [...new Map(
      ubicacionesBolsines.map((ubicacion) => [
        ubicacion.codigoComisionMedicaDestino,
        ubicacion.nombreComisionMedicaDestino,
      ]),
    )]
  }, [ubicacionesBolsines])

  const ubicacionesFiltradas = useMemo(() => {
    return ubicacionesBolsines.filter((ubicacion) => {
      const coincidePrecinto =
        precinto.trim() === '' ||
        String(ubicacion.numeroPrecinto ?? '').includes(precinto.trim())
      const coincideDestino =
        destino === 'todos' || ubicacion.codigoComisionMedicaDestino === destino

      return coincidePrecinto && coincideDestino
    })
  }, [destino, precinto, ubicacionesBolsines])

  return (
    <main className="tracking-screen">
      <header className="topbar">
        <div className="portal-brand">
          <span className="truck-icon" aria-hidden="true">▣</span>
          <strong>Logistics Portal</strong>
        </div>
        <nav className="topnav" aria-label="Seccion actual">
          <span>Seguimiento de Bolsines</span>
        </nav>
        <div className="top-actions" aria-hidden="true">
          <span className="user-icon">◎</span>
          <span className="avatar">LP</span>
        </div>
      </header>

      <div className="tracking-layout">
        <aside className="tracking-sidebar" aria-label="Panel de seguimiento">
          <section className="origin-panel">
            <h1>Seguimiento</h1>
            <p>
              CM Origen: <strong>{comisionMedica?.nombre ?? '-'}</strong>
            </p>
          </section>

          <form className="filters-panel">
            <label>
              <span>Nro. de Precinto</span>
              <input
                value={precinto}
                onChange={(event) => setPrecinto(event.target.value)}
                placeholder="Ej: 5001"
              />
            </label>

            <label>
              <span>CM Destino</span>
              <select
                value={destino}
                onChange={(event) => setDestino(event.target.value)}
              >
                <option value="todos">Todos los destinos</option>
                {destinos.map(([codigo, nombre]) => (
                  <option key={codigo} value={codigo}>
                    {nombre}
                  </option>
                ))}
              </select>
            </label>
          </form>

          <section className="bolsines-panel" aria-label="Bolsines encontrados">
            <div className="panel-caption">
              BOLSINES ({ubicacionesFiltradas.length})
            </div>

            {estadoConsulta === 'cargando' && (
              <p className="sidebar-status">Cargando bolsines...</p>
            )}

            {estadoConsulta === 'error' && (
              <p className="sidebar-status status-error">
                No se pudo obtener la ubicacion de los bolsines.
              </p>
            )}

            {estadoConsulta === 'lista' && ubicacionesFiltradas.length === 0 && (
              <p className="sidebar-status">Sin bolsines para los filtros.</p>
            )}

            <ul className="bolsin-list">
              {ubicacionesFiltradas.map((ubicacion, index) => (
                <li
                  className={`bolsin-card ${index === 1 ? 'warning' : ''}`}
                  key={ubicacion.numeroBolsin}
                >
                  <div className="card-title">
                    <strong>Precinto: {ubicacion.numeroPrecinto}</strong>
                    <span>{index === 1 ? 'DESVIADO' : 'EN TRANSITO'}</span>
                  </div>
                  <p>Destino: {ubicacion.nombreComisionMedicaDestino}</p>
                  <p>Act: Hoy, {formatearHora(ubicacion.fechaHoraUltimaActualizacion)}</p>
                </li>
              ))}
            </ul>
          </section>
        </aside>

        <TrackingMap ubicaciones={ubicacionesFiltradas} />
      </div>
    </main>
  )
}

export default App
