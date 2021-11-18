import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
import vuetify from './plugins/vuetify'
import axios from 'axios'
import VueResource from 'vue-resource'

Vue.use(VueResource)
const url = 'http://6c10-2806-109f-13-3405-df0-d88a-f862-7db9.ngrok.io';
Vue.http.options.root = url;
Vue.prototype.$urls = url;


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
