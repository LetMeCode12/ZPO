<template>
    <div id="list">
        <!-- wyszukiwanie tu -->
        <div id="contentList">
            
            <div id="headers">
             <a id="first"> # </a> <a> Pesel </a> <a> Imie </a> <a id="last"> Nazwisko </a>
            </div>
           
            <div id="row" v-for="(item,index) in data" v-bind:key="item">
                <a>{{index}}</a> <a>{{item.pesel}}</a> <a>{{item.name}}</a> <a>{{item.surrname}}</a> <a>{{item.nr_Budynku}}</a>
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

#row a{
    margin-left: auto;
    margin-right: auto;
}

#headers a{
    padding: 0px;
    margin-right: auto;
    margin-left:auto;
}

#headers #last{
    padding-right: 9.5vw;
}

#headers #first{
    padding-left: 1.5vw;
    margin-left: 0px;
}
</style>

