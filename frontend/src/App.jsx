import { useEffect, useState } from 'react'
import { consultarUbicacionBolsin } from './services/consultarBolsinService'
import './App.css'

function App() {
  const [comisionMedica, setComisionMedica] = useState(null)
  const [estadoConsulta, setEstadoConsulta] = useState('cargando')

  useEffect(() => {
    consultarUbicacionBolsin()
      .then((comision) => {
        setComisionMedica(comision)
        setEstadoConsulta('lista')
      })
      .catch(() => {
        setEstadoConsulta('error')
      })
  }, [])

  const datosComision = [
    ['Código', comisionMedica?.codigo],
    ['Nombre', comisionMedica?.nombre],
    ['Dirección', comisionMedica?.direccion],
    ['Teléfono', comisionMedica?.telefono],
    ['Email', comisionMedica?.email],
  ]

  return (
    <main className="bolsines-screen">
      <div className="decorative-wave" aria-hidden="true"></div>

      <section className="content-column" aria-labelledby="titulo-bolsines">
        <header className="brand">
          <div className="bag-logo" aria-hidden="true">
            <span className="bag-strap"></span>
            <span className="bag-body">
              <span className="bag-flap"></span>
            </span>
          </div>
          <span>Bolsines</span>
        </header>

        <h1 id="titulo-bolsines">Bolsines enviados</h1>

        <div
          className="map-placeholder"
          role="img"
          aria-label="Ubicación pendiente de mapa"
        >
          <div className="map-grid">
            <span className="river river-one"></span>
            <span className="river river-two"></span>
            <span className="street street-one"></span>
            <span className="street street-two"></span>
            <span className="street street-three"></span>
            <span className="park park-one"></span>
            <span className="park park-two"></span>
            <span className="park park-three"></span>
          </div>
        </div>
      </section>

      <aside className="info-column" aria-label="Comision medica">
        {estadoConsulta === 'cargando' && (
          <p className="status-message">Cargando comisión médica...</p>
        )}

        {estadoConsulta === 'error' && (
          <p className="status-message status-message-error">
            No se pudo obtener la comisión médica.
          </p>
        )}

        {estadoConsulta === 'lista' && (
          <dl className="medical-commission">
            {datosComision.map(([label, value]) => (
              <div className="commission-row" key={label}>
                <dt>{label}:</dt>
                <dd>{value || '-'}</dd>
              </div>
            ))}
          </dl>
        )}

        <div className="medical-symbol" aria-hidden="true">
          <svg viewBox="0 0 220 180">
            <path d="M110 30v132" />
            <circle cx="110" cy="22" r="13" />
            <path d="M93 55c-32 0-62-5-84-24 21 4 50 1 73-9 13-6 25-15 28-13 10 5-2 18 9 27" />
            <path d="M127 55c32 0 62-5 84-24-21 4-50 1-73-9-13-6-25-15-28-13-10 5 2 18-9 27" />
            <path d="M100 52c-23 1-45-1-66-7 7 9 22 12 37 14" />
            <path d="M120 52c23 1 45-1 66-7-7 9-22 12-37 14" />
            <path d="M110 84c-30 0-44-8-44-17 0 18 88 10 88 28 0 22-77 17-77 37 0 15 41 16 41 30" />
            <path d="M110 84c30 0 44-8 44-17 0 18-88 10-88 28 0 22 77 17 77 37 0 15-41 16-41 30" />
          </svg>
        </div>
      </aside>
    </main>
  )
}

export default App
