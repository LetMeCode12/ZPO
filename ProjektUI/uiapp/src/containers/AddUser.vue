<template>
<div id="Buildings"> 
    <h1 id="header">{{name}}</h1>
    <ul>
        <li @click="openModal"><span><img id="Icon" src="../icons/add-icon.svg"/><a>{{type}}</a></span></li>
        <li @click="back"><span><a>Wyjście</a><img id="Icon" src="../icons/back-icon.svg"/></span></li>
    </ul>
    <List v-if="renderComponent" v-bind:data="getData"/>
    <modals-container/>
</div>
</template>

<script>
import List from "../components/list/UsersList";
import addUserModal from '../components/modals/AddUser/addUserModal';
import {checkAccess} from '../seciurity/sciurityUtils'
export default {
    props:{
        name:{
            default:"Użytkownicy"
        },
        type:{
            default:"Dodaj użytkownika"
        },
        path:{
            default:"http://localhost:8080/Users/getUsr"
        }
    },
    components:{
        List
    },
    data(){
        return{
            renderComponent: this.$store.getters.update
        }
    },
    created:function(){
        this.$store.commit("getData",this.path)
    },
    computed:{
        getData(){
            return this.$store.getters.getData;  
        }
    },
    mouted(){
    },
    methods:{
        back(){
            this.$store.commit('goTo',"/homePage")
        },
        openModal(){
            window.console.log("Dziala")
            checkAccess();
            this.$modal.show(addUserModal,{draggable: true},{height: "400px"})
        }
    },
}
</script>

<style scoped>
*{
    background-image: none;
}

#header{
    background-color: azure;
    width: 99.5%;
    margin: 0;
    padding-top: 10px;
    padding-bottom: 10px;
    text-align: center;
    font-weight: 700;
    text-shadow:   2px 0px 5px grey;
    color:black;
}

#Icon{
    width: 30px;
    height: 30px;
    display: inline-block;
    vertical-align: middle;
    margin-right: 2%;
}

#Buildings{
    width: 50vw;
    height: 95vh;
    background-color: azure;
    left:25%;
    margin: 0;
    position: absolute;
    border-width: 2px;
    border-color: black;
    border-style: solid;
}

span{
    justify-content: center;
    position: relative;
    top: -3px;
}

ul{
    margin-top:0;
    padding-left: 0;
    padding-bottom: 10px;
    padding-top: 10px;
    list-style-type: none;
    background: azure;
    height: 50px;
    width:49.65vw;
    margin-bottom: 0;
    position: relative;
    padding-left: 0.3vw;
    border:black;
    border-width: 5px;
    border-bottom-style: double;
    border-top-style: double;
    
}

li{
    margin-left:0.3vw;
    float: left; 
    text-align: center;
    list-style-position: inside;
    color: black;
    margin-top:-1px;
    padding:15px 0;
    border-style: solid;
    border-width: 1px;
    height: 20px;
    width: 24vw;
    border-radius: 20px;
    
}

a{
    text-decoration: none;
    color: black;
    overflow: hidden;
    text-overflow: ellipsis;
    margin-right: 1vw;
}

li:hover, li:focus{
    background-color:#42bcf5;
    text-shadow:   2px 0px 8px black;
    font-weight: 600;
}
</style>