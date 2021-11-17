import Vue from 'vue'
import VueRouter from 'vue-router'
import Cars from '../views/Cars.vue'
import Gallery from '../views/Gallery.vue'
import Addcar from '../views/AddCar.vue'
import Detail from '../views/Detail.vue'
import Login from '../views/Login.vue'
import Pedidos from '../views/Pedidos.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/Cars',
    name: 'Inicio',
    icon: 'mdi-home',
    id: 0,
    component: Cars,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: true,
    },
    subMenu: [],
  },
  {
    path: '/',
    name: 'Galería',
    icon: 'mdi-home',
    id: 0,
    component: Gallery,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: false,
    },
    subMenu: [],
  },
  {
    path: '/pedidos',
    name: 'Pedidos',
    icon: 'mdi-account-supervisor-circle',
    id: 0,
    component: Pedidos,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: true,
    },
    subMenu: [],
  },
  {
    path: '/Addcar',
    name: 'Addcar',
    icon: 'mdi-home',
    id: 0,
    component: Addcar,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: false,
    },
    subMenu: [],
  },
  {
    path: '/Detail',
    name: 'Detail',
    icon: 'mdi-home',
    id: 0,
    component: Detail,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: false,
    },
    subMenu: [],
  },
  {
    path: '/Login',
    name: 'Login',
    icon: 'mdi-home',
    id: 0,
    component: Login,
    visible: true,
    user: true,
    menu: true,
    title: true,
    meta: {
      requiresAuth: false,
    },
    subMenu: [],
  },
/*
  {
    path: '/:catchAll(.*)*',
    icon: '',
    name: "PageNotFound",
    id: 0,
    component: "PageNotFound",
    visible: false,
    user: false,
    menu: false,
    title: false,
    meta: {
      requiresAuth: false,
    },
    subMenu: [],
  },*/
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
