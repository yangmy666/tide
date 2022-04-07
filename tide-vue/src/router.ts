import { createRouter, createWebHashHistory } from "vue-router"

//固定路由
const routes = [
  {
    path: '/',
    name: "Login",
    component: ()=>import('@/views/Login.vue')
  }
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
