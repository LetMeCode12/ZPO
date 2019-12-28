<template>
<div id="Login">
    <h1 id="napis">Logowanie</h1>
    <p id='error' :style="style">Błędne hasło lub login</p>
    <input id="loginInput" v-model="username" placeholder="Login"/>
    <br/>
    <input id="loginInput" v-model="password" type="Password"  placeholder="Hasło"/>
    <br/>
    <button id="buttonLogin" @click="login" @mousedown="onClick()" >Login</button>
</div>
</template>

<script>
export default {
 data () {
        return {
            username: '',
            password: '',
            submitted: false,
            error:false
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
       },
       style(){
           if(!this.error){
            return 'display:none;'
           }else{
            return 'display:ruby;'
           }
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

    
    #Login{       
        position: absolute;
        border-radius: 20px;
        border-width: 2px;
        border-style: solid;
        border-color: black;
        background-color: azure;
        width: 30vw;
        margin: auto;
        padding: 10px;
        text-align: center;
        overflow: hidden;
        background-image:none;  
        box-sizing: border-box;
        top:25%;
        left: 35%;
        text-align: center;
    }

    #napis{
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        background-color:azure;
        font-family: 'Courier New', Courier, monospace;
        background-image:none;  
    }

    #loginInput{
        width: 15vw;
        margin-top: 1%;
        background-color: azure;
        font-family: 'Courier New', Courier, monospace;
        text-align: center;
        border-radius: 20px;
        background-image:none;  

    }
    
    #buttonLogin{
        margin-top: 3%;
        width:10vw;
        height: 15%;
        border-radius: 20px;
        border-color:black;
        background-color:azure;
        color:black;
        font-weight: 600;
        font-family: 'Courier New', Courier, monospace;
        background-image:none;  
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      
    }

    #buttonLogin:hover{
        background-color: aqua;
        background-image:none;  
    }

    #error{
        background-image:none;  
        background-color: red;
        text-align: center;
    }

</style>