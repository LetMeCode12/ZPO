import Vue from 'vue';
import VueRouter from 'vue-router';
import Login from '../containers/Login.vue';
import HomePage from '../containers/HomePage.vue';
import NotFound from '../containers/NotFound.vue';
import Buildings from '../containers/Buildings.vue';
import Patients from '../containers/Patients.vue';
import Doctors from '../containers/Doctors.vue';
import {checkAccess} from "../seciurity/sciurityUtils"
Vue.use(VueRouter);

const router= new VueRouter({
    routes : [
        {path: '/',name:'Login', component: Login},

        {path:'/homePage',name:'HomePage',component: HomePage},

        {path:'/buildings',name:"Buildings",component: Buildings},

        {path:'/patients',name:"Patients",component: Patients},

        {path:'/doctors',name:"Doctors",component: Doctors},
        
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
