<template>
<div id="Modal">
    <div id="content">
    <div id="header"><h1>Budynek</h1></div>
    <div id="topcontent"><a>Adress :{{modalData.address}}</a>
    <br/>
    <a>Nr Budynku :{{modalData.nr_Budynku}}</a>
    </div> 
    
    <!-- <div>{{modalData}}</div> -->
    <div id="contentList">
        <div id="headers">
             <a> # </a> <a> Nr </a> <a id="center"> Oddział</a>
        </div>
    <div id="row" v-for="(item,index) in modalData.branches" v-bind:key="item">
        <a>{{index}}</a> <a>{{item.nr_Branch}}</a>  <a>{{item.branch_Name}}</a>  <img id="icons" @click="openModal(item.id)" src="../../../icons/info-icon.svg"/> <img id="icons" @click="_delete(item.id)" src="../../../icons/trash-icon.svg"/>
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
import modifyBranchModal from "../Branches/modifyBranchModal";
import { checkAccess } from '../../../seciurity/sciurityUtils';
import addBranchModalVue from '../Branches/addBranchModal.vue';
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
        },
        hide(){
             this.$emit('close');
        },
        async openModal(id){
          checkAccess();
          await this.$store.commit("getBranchId",id)  
          await window.console.log(this.$store.getters.modalData);
          this.$modal.show(modifyBranchModal,{draggable: true},{height: "700px"})

        },
        async _delete(id){
            checkAccess();
            window.console.log("ID:",id)
            let payload = {patch:`http://localhost:8080/api/Buildings/branchDelete/${id}`}
            await this.$store.commit("deleteData",payload)
            await this.$store.commit("getData","http://localhost:8080/api/Buildings/getAll")
            await location.reload();
        },
        setData(){
            this.$modal.show(addBranchModalVue,{draggable: true},{height: "400px"})
        }
    }
}
</script>

<style scoped>
*{
    background-image: none;
}

#headers #center{
    padding-right: 160px;
    padding-left: 20px;
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

#headers a{
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