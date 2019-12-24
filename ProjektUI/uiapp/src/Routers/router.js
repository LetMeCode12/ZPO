import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from '../containers/Login.vue';
import HomePage from '../containers/HomePage.vue';
import NotFound from '../containers/NotFound.vue'
import {checkAccess} from "../seciurity/sciurityUtils"
Vue.use(VueRouter);

const router= new VueRouter({
    routes : [
        {path: '/',name:'Login', component: Login},

        {path:'/homePage',name:'HomePage',component: HomePage},
        
        {path: '/404', component:NotFound},

        {path:'*', redirect: '/404'}
    ]
})

router.beforeEach((to,from,next)=>{
    if(to.fullPath !== "/"){
        checkAccess();
    }
    next();
})

export default router;
