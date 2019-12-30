import Vuex from 'vuex';
import Vue from 'vue';
import { login,logout, getData } from '../seciurity/sciurityUtils';
import router from '../Routers/router';

Vue.use(Vuex)

const store = new Vuex.Store({
        state:{
            message: 'Hello World',
            count:0,
            account:{
                Login:"",
                Password:"",
                Token:""
            },
            error:false,
            data:"brak fetcha"
        },
        mutations:{
            increment(state,payload){
                state.count+=payload;
            },
            logout(){
                logout();
            },
            async login(state,payload){
                await login(payload.Login,payload.Password)
            },
            goTo(state,payload){
                if(payload==='/'){
                    localStorage.removeItem('Account');
                }
                router.push({path:payload});
            },
            async getData(state,payload){
                window.console.log("Datastore:",payload)
                state.data= await getData(payload)
            }
        },
        actions:{

        },
        getters:{
            getData(state){
                return state.data;
            },
            account(state){
                return state.account;
            },
            message(state){
                return state.message.toUpperCase();
            },
            counter(state){
                return state.count;
            },
            error(state){
                return state.error;
            }
        }
})

export default store;