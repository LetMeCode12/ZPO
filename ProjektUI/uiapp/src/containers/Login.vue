<template>
<form @submit.prevent="handleSubmit">
<div id="main">
    <h1 id="napis">Logowanie</h1>
    <input id="loginInput" v-model="username" placeholder="Login"/>
    <br/>
    <input id="loginInput" v-model="password" placeholder="Hasło"/>
    <br/>
    <button id="buttonLogin" v-on:click="log($password)" >Login</button>
<!-- 
    <router-link id="buttonLogin"  tag="button"> Login </router-link> -->
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
        loggingIn () {
            return this.$store.state.authentication.status.loggingIn;
        }
    },
    created () {
        // reset login status
        this.$store.dispatch('authentication/logout');
    },
    methods: {
        log: (e)=>{
           // console.log(e.currentTarget);
            alert(e)
        },
        handleSubmit () {
            this.submitted = true;
            const { username, password } = this;
            const { dispatch } = this.$store;
            if (username && password) {
                dispatch('authentication/login', { username, password });
            }
        }
    }
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