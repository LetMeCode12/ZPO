<template>
<div id="Modal">
    <div id="content">
    <div id="header"><h1>Oddział</h1></div>
    <div id="topcontent">
    
    <a>Nazwa oddziału :{{modalData.branch_Name}}</a>
    <br/>
    <a>Nr :{{modalData.nr_Branch}}</a></div>  
    
    <div id="contentList">
        <div id="headers">
             <a id="first"> # </a> <a> Nr Pokoju </a> <a> Łóżka </a> <a id="last"> Wolne </a> 
        </div>
    <div id="row" v-for="(item,index) in modalData.rooms" v-bind:key="item">
        <a>{{index}}</a> <a>{{item.nr_Room}}</a> <a>{{item.beds.length}}</a> <a>{{item.beds.filter(e=>e.idPatient===null).length}}</a> <img id="icons" @click="openModal(item.id)" src="../../../icons/info-icon.svg"/> <img id="icons" @click="_delete(item.id)" src="../../../icons/trash-icon.svg"/>
    </div>
    </div>
     <div id="footer">
        <button id="Button" @click="setData">Dodaj</button>
        <button id="Button" @click="hide">Zamknij</button>
    </div>
</div>
</div>
</template>

<script>
import addRoomModalVue from "../../modals/Rooms/addRoomModal";
import modifyRoomModalVue from "../../modals/Rooms/modifyRoomModal";
import { checkAccess } from '../../../seciurity/sciurityUtils';
export default {
    
    data(){
        return{
            modalData:"NoData"
        }
    },
    created:function(){
           this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData).branches.find(e=>e.id===this.$store.getters.getBranchId);
           window.console.log("modalData:",this.modalData)
    },
    methods:{
        findData(){
            window.console.log(this.modalData);
        },
        hide(){
             this.$emit('close');
        },
         setData(){
             checkAccess();
            this.$modal.show(addRoomModalVue,{draggable: true},{height: "400px"})
        },
          async _delete(id){
            checkAccess();
            window.console.log("ID:",id)
            let payload = {patch:`http://localhost:8080/api/Buildings/roomDelete/${id}`}
            await this.$store.commit("deleteData",payload)
            await this.$store.commit("getData","http://localhost:8080/api/Buildings/getAll")
            await location.reload();
        },
        async openModal(id){
          checkAccess();
          await this.$store.commit("getRoomId",id)  
          await window.console.log(this.$store.getters.modalData);
          this.$modal.show(modifyRoomModalVue,{draggable: true},{height: "700px"})

        },
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
    padding-right: 0px;
}

#headers #first{
    padding-left: 25px;
}

#headers #last{
    padding-right: 140px;
}

#headers a{
    padding-left: 0px;
    margin-left: auto;
    margin-right: auto;
    padding-right: 0px;
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