<template>
<div id="HomePage"> 

    <Box name="Budynki" color='azure' hovercolor='#42bcf5' onClick='/buildings'/>
    <Box name="Pacjęci" color='azure' hovercolor='#42bcf5' onClick='/patients'/>
    <Box name="Lekarze" color='azure' hovercolor='#42bcf5' onClick='/doctors'/>
    <Box name="Dodaj konto" color='azure' hovercolor='#42bcf5'/>
    <Box name="Profil" color='azure' hovercolor='#42bcf5'/>
    <Box name="Wyloguj" color='azure' hovercolor='#42bcf5' onClick='/'/>

</div>
</template>

<script>
import Box from "../components/menuBox/box";
export default {
    components:{
        Box
    },
    data(){
        return{
            namePage:"HomePage",
        }
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
    },
}
</script>

<style scoped>
#HomePage{
    width: 50vw;
    height: 50vh;
    background-color: aliceblue;
    left:25%;
    top:25%;
    margin: 0;
    position: absolute;
    border-width: 2px;
    border-color: black;
    border-style: solid;
    background-image:none;  
}

</style>