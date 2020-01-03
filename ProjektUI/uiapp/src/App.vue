<template>
    <div>
        <router-view ></router-view>
    </div>
</template>
<script>
//https://garywoodfine.com/using-vuex-and-vue-router-in-a-vue-project/

export default {
    name: 'app',
    el:'#Login',
}
</script>

<style>
*{
    font-family: 'Courier New', Courier, monospace;
    background-image:url('image.jpg'); 
    background-size: 100%   
}

.v--modal-background-click{
    background-image: none;
}

.v--modal-box{
    background-image: none;
}

#Input{
    width: 15vw;
    margin-top: 1%;
    background-color: azure;
    font-family: 'Courier New', Courier, monospace;
    text-align: center;
    border-radius: 20px;
    background-image:none;  
}

#Button{
    margin-top: 3%;
    width:10vw;
    height: 15%;
    border-radius: 20px;
    border-color:black;
    background-color:azure;
    color:black;
    font-weight: 600;
    font-family: 'Courier New', Courier, monospace;
    background-image:none;  
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;      
}

#Button:hover{
    background-color: aqua;
    background-image:none;  
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
    padding-right: 7vw;
}

#row #center{
    margin-right: auto;
    margin-left: auto;
}

#headers #center{
    margin-right: auto;
    margin-left: auto;
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