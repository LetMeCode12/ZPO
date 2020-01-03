<template>
    <div id="list">
        <!-- wyszukiwanie tu -->
        <div id="content">
            
            <div id="headers">
             <a> # </a> <a id="center"> Nazwa </a>  <a> Nr </a>
            </div>
           
            <div id="row" v-for="(item,index) in data" v-bind:key="item">
                <a>{{index}}</a> <a id="center">{{item.address}}</a> <a>{{item.nr_Budynku}}</a>
                 <img id="icons" src="../../icons/info-icon.svg"/> <img id="icons" src="../../icons/trash-icon.svg"/>
            </div>
            
        </div>
    
    </div>
</template>

<script>
import '../../icons/info-icon.svg'
export default {
    props:{
        name:{
            default:"lista"
        },
        data:{
            default:[]
        }
    },
    components:{
    
    }
}
</script>

<style scoped>

*{
   background-image: none;
}
</style>