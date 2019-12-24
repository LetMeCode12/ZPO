import Vuex from 'vuex';
import Vue from 'vue';
import Axios from 'axios';
import { setToken, goHome } from '../seciurity/sciurityUtils';
// import { setToken } from '../seciurity/sciurityUtils';

Vue.use(Vuex)

const store = new Vuex.Store({
        state:{
            message: 'Hello World',
            count:0,
            account:{
                Login:"",
                Password:"",
                Token:""
            }
        },
        mutations:{
            increment(state,payload){
                state.count+=payload;
            },
            async login(state,payload){
                let _data={
                  login:payload.Login,
                  password:payload.Password
                }
                let respones =await Axios.post("http://localhost:8080/logIn",_data);
                let data = await respones.data;
                await setToken(data,_data,goHome)    
            }

        },
        actions:{

        },
        getters:{
            account(state){
                return state.account;
            },
            message(state){
                return state.message.toUpperCase();
            },
            counter(state){
                return state.count;
            }
        }
})

export default store;