import Vue from 'vue'
import App from '../src/App'
import store from './store/store'
import router from'./Routers/router'
import VModal from 'vue-js-modal'

Vue.config.productionTip =false;
Vue.use(VModal,{
  dynamic: true 
  ,injectModalsContainer: true
})


new Vue({
  router,
  store,
  render:h=>h(App)
}).$mount("#app")
