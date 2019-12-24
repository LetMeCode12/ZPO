<template>
<form>
<div id="Login">
    <h1 id="napis">Logowanie</h1>
    <input id="loginInput" v-model="username" placeholder="Login"/>
    <br/>
    <input id="loginInput" v-model="password" placeholder="Hasło"/>
    <br/>
    <button id="buttonLogin" @click="login" >Login</button>
    <h1>{{account}}</h1>
    <!-- <router-link   to='/homePage'> Home </router-link> -->
</div>
</form>
</template>

<script>
export default {
 data () {
        return {
            username: '',
            password: '',
            submitted: false
        }
    },
    computed: {
       message(){
            return this.$store.getters.message;
       },
       count(){
           return this.$store.getters.counter;
       },
       account(){
           return this.$store.getters.account;
       }
    },
    methods:{
        pressed(){
            this.$store.commit('increment',10)
        },
        login(){
            this.$store.commit('login',{Login:this.username,Password:this.password});
        }
    },
};
    

</script>

<style scoped>

    
    #main{
        top: 25%;
        left:30%;
        position:absolute;
        border-radius: 20px;
        border-width: 2px;
        border-style: solid;
        border-color: black;
        background-color: azure;
        width: 40%;
        margin: auto;
        height: 30%;
        padding: 10px;
        text-align: center;
        overflow: hidden;
    }

    #napis{
        background-color:azure;
        font-family: 'Courier New', Courier, monospace;
    }

    #loginInput{
        margin-top: 1%;
        background-color: azure;
        font-family: 'Courier New', Courier, monospace;
        text-align: center;
        border-radius: 20px;
    }
    
    #buttonLogin{
        margin-top: 5%;
        width:25%;
        height: 15%;
        border-radius: 20px;
        border-color:black;
        background-color:azure;
        color:black;
        font-weight: 600;
        font-family: 'Courier New', Courier, monospace;
    }

    #buttonLogin:hover{
        background-color: aqua;
    }

</style>