<template>
    <div>
        XDDD
        <router-view ></router-view>
    </div>
</template>
<script>


export default {
    name: 'app',

    computed: {
        alert(){
            return this.$store.state.alert
        }
    },
    watch:{
        $route (){
            this.$store.dispatch('alert/clear');
        }
    }
}
</script>

<style>
/* * {
    margin: auto;
    padding:0;
    box-sizing: border-box;
    background-color: aqua;    
    
} */
</style>