<template>
<div>
    <h1>Test PageXD</h1>
    <button id="button1" v-on:click="click()">Go to other</button>
    <router-link id="button2" to="/" tag="button"> back to login </router-link>
</div>
</template>

<script>
import { mapMutations } from 'vuex'
//import store from "../store/store"
export default {
    el:'#button1',
    methods:{
        ...mapMutations([
            'addItem'
        ]),
        click: function(){
            alert("store ")
        }
    }
}
</script>

<style scoped>
#button2{
    background-color: aqua;
    border-radius: 20px;
}
</style>