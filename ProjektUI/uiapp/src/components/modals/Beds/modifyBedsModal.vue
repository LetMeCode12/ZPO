<template>
<div id="Modal">
    <div id="content">
    <div id="header"><h1>Łóżko</h1></div>
        
    <div id="contentList">
            <a></a>
    </div>
     <div id="footer">
        <!-- <button id="Button" @click="setData">Dodaj</button> -->
        <button id="Button" @click="hide">Zamknij</button>
    </div>
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
           this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData).branches.find(e=>e.id===this.$store.getters.getBranchId).rooms.find(r=>r.id===this.$store.getters.getRoomId).beds.find(e=>e.idBed===this.$store.getters.getBedId)
           window.console.log("modalData:",this.modalData)
           window.console.log("roomid",this.$store.getters.getRoomId);
           window.console.log("branch id:",this.$store.getters.getBranchId)
    },
    methods:{
        findData(){
            window.console.log(this.modalData);
        },
        hide(){
             this.$emit('close');
        }
    }
}
</script>

<style scoped>
*{
    background-image: none;
}


#topcontent {
    padding-top:10px;
    font-size: 20px;
    text-align: center;
    font-weight: 600;
}

#header{
    border-bottom-style: solid;
    border-bottom-width: 2px;
    border-bottom-color: black;
}

#footer{
    position:relative;
    align-items: center;
    bottom: 9px; 
    display: flex;
}

#Button{
    margin-right: auto;
    margin-left: auto; 
}

#contentList{
    height: 480px;
    width: 500px;
    margin-left: auto;
    margin-right: auto;
}

h1{
    text-align: center;
}

#headers{
    padding-right: 90px;
}

#headers a{
    padding-left: 35px;
    margin-left: auto;
    margin-right: auto;
}

#row a{
    margin-left: auto;
    margin-right: auto;
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