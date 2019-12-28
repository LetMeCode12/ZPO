<template>
    <div id="one" :style="style" @mouseover="mouseOver()" @mouseout="mouseout()" @mousedown="mouseClick()">
        <h1 id="name" :style="style">{{name}}</h1>
    </div>
</template>

<script>
export default {
    name:'box',
    props:{
        name:{
            default:"Test"
        },
        color:{
            default:"green"
        },
        hovercolor:{
            default:"blue"
        },
        onClick:{
            default:""
        }
        
    },
    data(){
       return{
           hovering:false
       }
    },
    created:function(){
    },
    computed:{
        style(){
            if(this.hovering){
             return 'background-color: '+this.hovercolor + ';font-weight: 600;'
            }else{
             return 'background-color: '+this.color
            }
        }
    },
    mouted(){
    },
    methods:{
        mouseOver(){
            this.hovering = true
        },
        mouseout(){
            this.hovering =false
        },
        mouseClick(){
            this.$store.commit('goTo',this.onClick)
            //this.$store.commit(this.onClick)
        }
        
    },
}
</script>

<style scoped>

#one{
    width: 16.65vw;
    height: 50%;
    border-width: 1px;
    border-color: black;
    border-style: solid;
    float: left;
    box-sizing: border-box;
    background-image:none;  
}

#name{
    margin-top:25%;
    text-align: center;
    font-family:'Courier New', Courier, monospace;
    text-shadow: 0 0 0.05em;
    font-weight: 200;
    text-overflow: ellipsis;
    overflow: hidden;
    background-image:none;  
}

</style>