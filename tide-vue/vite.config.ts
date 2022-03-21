import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  base: './',
  server: {
    port: 80,
    open: true
  },
  build: {
    minify: 'terser',
    terserOptions: {
      compress: {
        //生产环境打包移除console.log
        drop_console: true,
        drop_debugger: true
      }
    }
  }
})
