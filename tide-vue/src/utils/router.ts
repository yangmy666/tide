import { createRouter, createWebHashHistory } from "vue-router"

//固定路由
const routes = [
  {
    path: '/login',
    component: ()=>import('@/views/Login.vue')
  },
  {
    path: '/register',
    component: ()=>import('@/views/Register.vue')
  },
  {
    path: '/',
    component: ()=>import('@/views/HomePage.vue')
  },
  {
    path: '/system/user',
    component: ()=>import('@/views/system/user/index.vue')
  },

]

const router = createRouter({
  history: createWebHashHistory(),
  routes: routes,
})

//路由守卫
// router.beforeEach((to, from, next) => {
//
// })
//
// router.afterEach(() => {
//
// })

export default router
