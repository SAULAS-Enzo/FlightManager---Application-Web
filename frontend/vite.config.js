import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'



export default defineConfig({
    plugins: [react()],
    resolve: {
        extensions: ['.js', '.jsx']
    },
    server:{
        proxy:{
            '/req':{
                target: "http://localhost:8080",
                changeOrigin: true
            }
        }
    }
})