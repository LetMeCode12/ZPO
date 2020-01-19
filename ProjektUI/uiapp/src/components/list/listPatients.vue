<template>
    <div id="list">
        <!-- wyszukiwanie tu -->
        <input id="Input" type="number" placeholder="Pesel" v-model="Wwyszukaj"><button id="Button" @click="wyszukaj">Wyszukaj</button>
        <div id="contentList">
            
            <div id="headers">
             <a id="first"> # </a> <a> Pesel </a> <a> Imie </a> <a> Nazwisko </a> <a id="last"> Opłaty </a>
            </div>
           
            <div id="row" v-for="(item,index) in (!wyszukane[0]?data:wyszukane)" v-bind:key="item">
                <a>{{index}}</a> <a>{{item.pesel}}</a> <a>{{item.name}}</a> <a>{{item.surrname}}</a> <a>{{item.costs}} zł</a> <a>{{item.nr_Budynku}}</a>
                 <img id="icons" @click="openModal(item.id)" src="../../icons/info-icon.svg"/> <img id="icons" @click="_delete(item.id)" src="../../icons/trash-icon.svg"/>
            </div>
        </div>
    <modals-container/>
    </div>
</template>

<script>
import '../../icons/info-icon.svg'
import { checkAccess } from '../../seciurity/sciurityUtils';
import modifyPatientsModal from'../modals/Patients/modifyPatientsModal';
export default {
    data(){
        return{
            Wwyszukaj:undefined,
            wyszukane:[]
        }
    },
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
          this.$modal.show(modifyPatientsModal,{draggable: true},{height: "700px"})

        },
       async _delete(id){
            checkAccess();
            window.console.log(id)
            let payload = {patch:`http://localhost:8080/api/Patients/deletePatient/${id}`}
            await this.$store.commit("deleteData",payload)
            await this.$store.commit("getData","http://localhost:8080/api/Buildings/getAll")
            await location.reload();
        },
        wyszukaj(){
            window.console.log("wyszukaj:",this.Wwyszukaj);
            this.wyszukane=this.data.filter(e=>e.pesel===this.Wwyszukaj);
            window.console.log("wyszukane!!:",this.wyszukane);
        }
    }
}
</script>

<style scoped>

*{
   background-image: none;
}

#Input{
    margin-left: 1.7vw;
}

#Button{
    width: auto;
    height: auto;
}

#row a{
    margin-left: auto;
    margin-right: auto;
}

#headers a{
    padding-left:0px;
    margin-right: auto;
    margin-left:auto;
    padding-right: 3.5vw;
}

#headers #last{
    padding-right: 8.5vw;
}

#headers #first{
    padding-left: 1.5vw;
    margin-left: 0px;
}
</style>

