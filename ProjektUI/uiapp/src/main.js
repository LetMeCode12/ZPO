import Vue from 'vue'
import App from '../src/App'
import store from './store/store'
import router from'./Routers/router'

Vue.config.productionTip =false;


new Vue({
  router,
  store,
  render:h=>h(App)
}).$mount("#app")
