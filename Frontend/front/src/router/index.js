import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import inicio from '../views/Inicio.vue'
import MisCuentas from '../views/MisCuentas.vue'
import Historial from '../views/Historial.vue'
import Facturas from '../views/Facturas.vue'
import construccion from '../views/Construccion.vue'
const routes = [
  {
    path: '/',
    name: 'inicio',
    component: inicio
  },
  {
    path: '/misCuentas/:id',
    name: 'misCuentas',
    component: MisCuentas
  },
  {
    path: '/Historial/:id',
    name: 'Historial',
    component: Historial
  },
  {
    path: '/Facturas/:id',
    name: 'Facturas',
    component: Facturas
  },
  {
    path: '/construccion',
    name: 'construccion',
    component: construccion
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
