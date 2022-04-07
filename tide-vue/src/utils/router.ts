import { createRouter, createWebHashHistory } from "vue-router"

//固定路由
const routes = [
  {
    path: '/',
    component: ()=>import('@/views/Login.vue')
  },
  {
    path: '/system/user',
    component: ()=>import('@/views/system/user/index.vue')
  },
  {
    path: '/test/table',
    component: ()=>import('@/components/Table.vue')
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
