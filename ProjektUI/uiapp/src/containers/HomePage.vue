<template>
<div> 
    <h1>{{namePage}}</h1>
    <button id="button1" v-on:click="click()">Go to other</button>
    <router-link id="button2" to="/" tag="button"> back to login </router-link>
    
        <h1>{{message}}</h1>
    
        <h1>{{count}}</h1>
        <button @click="pressed">presser</button>
        <router-link to="/404"> go to login</router-link>

        <input v-model="tokenValue"/>
        <button @click="clickSetToken">setToken</button>
        <button @click="clickToken">getToken</button>
       <h1>{{tokenValueGet}}</h1>
       <h1>{{getAccount}}</h1>
</div>
</template>

<script>
import {getToken} from "../seciurity/sciurityUtils"
export default {
    data(){
        return{
            namePage:"HomePage",
            tokenValue:"",
            tokenValueGet:""
        }
    },
    created:function(){
   
       // checkAccess();
    },
    computed:{
      message(){
            return this.$store.getters.message;
       },
       count(){
           return this.$store.getters.counter;
       },
       getAccount(){
           return this.$store.getters.account;
       }
    },
    mouted(){
    },
    methods:{
        pressed(){
            this.$store.commit('increment',10)
        },
        clickToken(){
            alert(getToken())
        }
    },
}
</script>

<style scoped>
#button2{
    background-color: aqua;
    border-radius: 20px;
}
</style>