import { createRouter, createWebHashHistory } from "vue-router"

//固定路由
const routes = [
  {
    path: '/test',
    component: ()=>import('@/pages/Test.vue'),
  },
  {
    path: '/',
    component: ()=>import('@/pages/HomePage.vue'),
    children:[
      {
        path: '/recommend',
        component: ()=>import('@/pages/Recommend.vue')
      },

    ]
  },
  {
    path: '/questionContext',
    component: ()=>import('@/pages/QuestionContext.vue')
  },
  {path: '/register', component: ()=>import('@/pages/Register.vue')}
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
