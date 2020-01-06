<template>
<div id="Modal">
    <div id="content">
    hello modal
    {{modalData.nr_Budynku}} {{modalData.address}} {{modalData.branches}}
    <button @click="findData">show Data</button>
    </div>
</div>
</template>

<script>
export default {
    data(){
        return{
            modalData:"NoData"
        }
    },
    created:function(){
           this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData);
    },
    methods:{
        findData(){
            window.console.log(this.modalData);
        }
    }
}
</script>

<style scoped>
*{
    background-image: none;
}

#Modal{
    background-image: none;
    background-color: #42bcf5;
    width: 100%;
    height: 100%;
    position: absolute;
}

#content{
    background-color: azure;
    height: 680px;
    width:580px;
    align-items: center;
    position: sticky;
    top:1.2%;
    left:1.2%;
    border-radius: 5px;
    border-color: black;
    border-width: 3px;
    border-style: solid;
    position: absolute;
    margin-left: auto;
    margin-right: auto;
    margin-top:auto;
}

</style>