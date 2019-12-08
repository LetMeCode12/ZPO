<template>
<div>
    <h1>Test PageXD</h1>
    <button id="button1" v-on:click="click()">Go to other</button>
    <router-link to="/" tag="button"> back to login </router-link>
</div>
</template>

<script>
export default {
    el:'#button1',
    methods:{
        click: function(){
            alert("Click")
        }
    }
}
</script>