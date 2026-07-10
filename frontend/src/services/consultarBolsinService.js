import axios from 'axios'

const API_BASE_URL = import.meta.env.VITE_API_URL ?? 'http://localhost:8080'

export async function consultarUbicacionBolsin() {
  const { data } = await axios.post(
    `${API_BASE_URL}/bolsines/consultar-ubicacion`,
  )

  return data.comisionMedicaUsuarioLogueado
}
