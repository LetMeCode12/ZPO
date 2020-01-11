import Vuex from 'vuex';
import Vue from 'vue';
import { login,logout, getData, setData, deleteData } from '../seciurity/sciurityUtils';
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
            data:"brak fetcha",
            update:true,
            modalData:"No data",
            getBranchId:"NoID",
            getRoomId:"NoID",
            getBedId:"NoID"
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
            },
            async setData(state,payload){
                await setData(payload)
            },
            async deleteData(state,payload){
                await deleteData(payload)
            },
            setModalData(state,payload){
                state.modalData=payload
            },
            getBranchId(state,payload){
                state.getBranchId=payload;
            },
            getRoomId(state,payload){
                state.getRoomId=payload;
            },
            getBedId(state,payload){
                state.getBedId=payload;
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
            },
            update(state){
                return state.update;
            },
            modalData(state){
                return state.modalData;
            },
            getBranchId(state){
                return state.getBranchId;
            },
            getRoomId(state){
                return state.getRoomId;
            },
            getBedId(state){
                return state.getBedId;
            }
        }
})

export default store;