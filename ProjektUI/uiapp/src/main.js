import Vue from 'vue'
//import Login from "./containers/Login.vue" 
//import Test from "./containers/TestPage.vue" 
//import VueRouter from 'vue-router'
//import {store} from './_store';
import {router} from './_helpers';
import App from '../src/App'

import { configureFakeBackend } from './_helpers';

// const router = new VueRouter({
//   routes: [
//     {path: '/', component:Login},
//     {path: '/test', component:Test}
//   ],
//   mode: "history"
// })

configureFakeBackend();

new Vue({
  el: '#app',
  router,
  //store,
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
