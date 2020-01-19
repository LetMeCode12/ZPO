<template>
    <div id="Modal">
        <div id="content">
        <div id="Header">
            <h1>Dodawanie Użytkownika</h1>
        </div>
        <div id='MainContent'>
        <input id="Input" v-model="Login" placeholder="Login"/>
        <br/>
        <input id="Input" v-model="Password" type="Password" placeholder="Password"/>
        </div>
        <div id="footer">
        <button id="Button" @click="setData">Dodaj</button>
        <button id="Button" @click="hide">Zamknij</button>
        </div>
        
        </div>
    </div>
</template>

<script>

export default {

    data () {
        return {
            Login: undefined,
            Password: undefined,
        }
    },
    props:{
        name:{
            default:""
        },
       
    },
    methods:{
        hide(){
            this.$emit('close');
        },
       async setData(){       
           if(this.Login && this.Password ) { 
         let payload = {patch:"http://localhost:8080/Users/signIn",data:{login:this.Login,password:this.Password,admin:true}}
           window.console.log("XDD:",payload)
           
           await this.$store.commit("setData",payload)
          
           await location.reload();
           await this.$emit('close'); 
           }else{
               alert("Prosze wypełnić pola!")
           }
         
        }
    }
}
</script>

<style scoped>
*{
    background-image: none;
}

#Header{
    position: relative;
    text-align: center;
    
}

#footer{
    position:relative;
    align-items: center;
    bottom: -20px; 
    display: flex;
}

#Button{
    margin-right: auto;
    margin-left: auto; 
}

#MainContent{
   top:20px;
   position: relative;
   display: grid;
   align-items: center;
   text-align: center;
}

#select{
    float: left;
}

#MainContent select{
    width:auto;
    appearance: none;
    margin-right: auto;
    margin-left: auto; 
    border-radius: 2px;
    text-align: center;
    background-color: azure;
}

#Input{
  margin-right: auto;
  margin-left: auto;  
  margin-bottom: 20px;
  margin-top:20px;
}

#Modal{
    background-image: none;
    background-color: #42bcf5;
    width: 100%;
    height: 100%;
    position: absolute;
}

#content{
    background-color: azure;
    height: 380px;
    width:580px;
    align-items: center;
    position: sticky;
    top:1.2%;
    left:1.2%;
    border-radius: 5px;
    border-color: black;
    border-width: 3px;
    border-style: solid;
    position: absolute;
    margin-left: auto;
    margin-right: auto;
    margin-top:auto;
}


</style>