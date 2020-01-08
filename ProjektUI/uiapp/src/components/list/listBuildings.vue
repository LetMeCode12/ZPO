<template>
    <div id="list">
        <!-- wyszukiwanie tu -->
        <div id="contentList">
            
            <div id="headers">
             <a> # </a> <a id="center"> Nazwa </a>  <a> Nr </a>
            </div>
           
            <div id="row" v-for="(item,index) in data" v-bind:key="item">
                <a>{{index}}</a> <a id="center">{{item.address}}</a> <a>{{item.nr_Budynku}}</a>
                 <img id="icons" @click="openModal(item.id)" src="../../icons/info-icon.svg"/> <img id="icons" @click="_delete(item.id)" src="../../icons/trash-icon.svg"/>
            </div>
        </div>
    <modals-container/>
    </div>
</template>

<script>
import '../../icons/info-icon.svg'
import { checkAccess } from '../../seciurity/sciurityUtils';
import modifyBuildingsModal from'../modals/Buildings/modifyBuildingsModal';
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
    
    },
    methods:{
        async openModal(id){
          checkAccess();
          await this.$store.commit("setModalData",id)  
          await window.console.log(this.$store.getters.modalData);
          this.$modal.show(modifyBuildingsModal,{draggable: true},{height: "700px"})

        },
       async _delete(id){
            checkAccess();
            window.console.log(id)
            let payload = {patch:`http://localhost:8080/api/Buildings/deleteBuilding/${id}`}
            await this.$store.commit("deleteData",payload)
            await this.$store.commit("getData","http://localhost:8080/api/Buildings/getAll")
            await location.reload();
        }
    }
}
</script>

<style scoped>

*{
   background-image: none;
}
</style>