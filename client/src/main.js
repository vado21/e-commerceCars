import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const url = 'http://8d7b-2806-109f-13-1883-6587-bbfb-55cb-d491.ngrok.io/';
Vue.http.options.root = url;
Vue.prototype.$urls = url;


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
