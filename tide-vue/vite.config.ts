import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
const path = require("path");

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  base: './',
  server: {
    port: 80,
    //启动后打开浏览器
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
  },
  resolve: {
    // 配置路径别名
    alias: {
      '@/': path.join(__dirname, 'src/')
    }
  }
})


