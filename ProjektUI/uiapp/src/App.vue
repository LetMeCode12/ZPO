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

</style>