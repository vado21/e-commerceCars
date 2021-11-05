import Vue from 'vue'
import VueRouter from 'vue-router'
import Cars from '../views/Cars.vue'
import Gallery from '../views/Gallery.vue'
import Addcar from '../views/AddCar.vue'



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
    path: '/Gallery',
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
    path: '/Addcar',
    name: 'Agregar Carro',
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
