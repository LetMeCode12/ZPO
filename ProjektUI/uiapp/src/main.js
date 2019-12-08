import Vue from 'vue'
import App from './App.vue'
//import router from './router'
import Login from "./containers/Login.vue" 
import Test from "./containers/TestPage.vue" 
//import Notfound from "./containers/NotFound.vue"
import VueRouter from 'vue-router'
//Vue.config.productionTip = false

Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    {path: '/', component:Login},
    {path: '/test', component:Test}
  ],
  mode: "history"
})

new Vue({
  router,
  render:h=>h(App)
}).$mount("#app")

// new Vue({
//   el:'#app',
//   data: {
//     currentRoute:window.location.pathname
//   },
//   computed:{
//     ViewComponent(){
//       switch(this.currentRoute){
//         case '/':
//           return Login
//           default:
//           return Notfound
//       }
//       //return Login
//      // return routes[this.currentRoute]||Notfound
//     }
//   },
//   render(h){return h(this.ViewComponent)}
// })
