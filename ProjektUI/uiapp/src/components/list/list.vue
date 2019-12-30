<template>
    <div id="list">
        test wyszukiwanie tu
        <div id="content">
            data:{{data}}
        </div>
    
    </div>
</template>

<script>
export default {
    props:{
        name:{
            default:"lista"
        },
        data:{
            default:[]
        }
    },
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
    height: 350px;
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
    height: 295px;
    border-width: 2px;
    border-color: black;
    border-style: solid;
}

</style>