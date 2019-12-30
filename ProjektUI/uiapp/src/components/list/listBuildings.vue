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

#list{
    background-color: gray;
    margin-left: 2.8vw;
    margin-top: 20px;
    width: 44vw;
    height: 720px;
    background-color: #42bcf5;
    border-radius: 10px;
    border-width: 2px;
    border-color: black;
    border-style: solid;
}

#content{
    background-color: azure;
    width: 40vw;
    margin-left: 1.8vw;
    margin-top: 20px;
    height: 650px;
    border-width: 2px;
    border-color: black;
    border-style: solid;
}

#headers{
    display: flex;
    margin-top: 2px;
    border-bottom-style: solid;
    border-color: black;
    border-width: 2px;
    padding-left: 1vw;
    
}

#row{
    display: flex;
    margin-top: 10px;
    padding-bottom: 10px;
    border-bottom-style: dashed;
    border-color: black;
    border-width: 2px;
    padding-left: 1vw;
    
}

#row a{
    font-weight: 600;
    font-size: 20px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

#headers a{
    font-weight: 700;
    font-size: 20px;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}

#row #center{
    margin-right: 12vw;
    margin-left: 12vw;
}

#headers #center{
    margin-right: 12.75vw;
    margin-left: 12.5vw;
}

#icons{
    margin-left: 1.5vw;
    float: right;
    width: 2vw;
    height: 20px;
}

#icons:hover{
    transform: scale(1.5,1.5)
}
</style>