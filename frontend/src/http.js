import axios from 'axios'

// Grâce au proxy Vite, on peut utiliser directement /api
export const http = axios.create({
    baseURL: 'http://localhost:8080/api',
    headers:{'Content-Type': 'application/json'}
})

// Intercepteur pour log ou gérer les erreurs
http.interceptors.response.use(
    (response) => response,
    (error) => Promise.reject(error)
)