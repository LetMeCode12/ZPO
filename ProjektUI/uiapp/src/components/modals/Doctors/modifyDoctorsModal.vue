<template>
<div id="Modal">
    <div id="content">
    <div id="header"><h1>Doktor</h1></div>
    <div id="topcontent">
        <!-- <a>Adress :{{modalData}}</a> -->
    <br/>
    <a>Imie :{{modalData.name}}</a>
    <br/>
    <a>Nazwisko :{{modalData.surrname}}</a>
    <br/>
    <a>Specializacja :{{modalData.specialization}}</a>
    <br/>
    <a>Oddział :{{(branches[0]?branches.find(e=>e.id===modalData.branchID).branch_Name:"Nie przypisano")}}</a>
    <br/>
       <div id="contentList">
            
            <div id="headers">
              <a> Pesel </a> <a> Imie </a> <a> Nazwisko </a> <a id="last"> Opłaty </a>
            </div>
           
            <div id="row" v-for="(item,index) in patients" v-bind:key="item">
                <a>{{index}}</a> <a>{{item.pesel}}</a> <a>{{item.name}}</a> <a>{{item.surrname}}</a> <a>{{item.costs}} zł</a> <a>{{item.nr_Budynku}}</a>
                 <img id="icons" @click="openModal(item.id)" src="../../../icons/info-icon.svg"/> <img id="icons" @click="_delete(item.id)" src="../../../icons/trash-icon.svg"/>
            </div>
        </div>
    </div> 
    
    
<div id="footer">
        <!-- <button id="Button" @click="setData">Dodaj</button> -->
        <button id="Button" @click="hide">Zamknij</button>
    </div>
</div>
</div>
</template>

<script>
import modifyPatientsModal from "../Patients/modifyPatientsModal";
import { checkAccess, getData} from '../../../seciurity/sciurityUtils';
import addBranchModalVue from '../Branches/addBranchModal.vue';
export default {
    data(){
        return{
            modalData:"NoData",
            zaległość:0,
            patients:[],
            selectedDoctor:"",
            branches:[]
        }
    },
    created: async function(){
        let payload = `http://localhost:8080/api/Patients/getAll`
                let payload2 = `http://localhost:8080/api/Buildings/getAllBranch`
           this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData);
        this.patients=await getData(payload)
        this.branches=await getData(payload2)
        this.patients=this.patients.filter(e=>e.doctorID===this.modalData.id)
        window.console.log("Pacjenty:",this.patients)
        window.console.log("Branchesy:",this.branches)
    },
    methods:{
        showdata(){
            window.console.log("dane:",this.modalData)
        },
        async change (){
            window.console.log("XDDD",this.modalData);
            let payload = {type:"PUT",patch:`http://localhost:8080/api/Patients/updatePatient/${this.modalData.id}`,data:{costs:this.modalData.costs,doctorID:this.modalData.doctorID,insurance:!this.modalData.insurance}}
            await this.$store.commit("setData",payload)
            this.modalData.insurance=!this.modalData.insurance
        },
        async findData(){
            window.console.log("XDDD",this.selectedDoctor);
           // this.modalData.doctorID=this.doctors.find(e=>e.id===this.selectedDoctor).name
            let payload = {type:"PUT",patch:`http://localhost:8080/api/Patients/updatePatient/${this.modalData.id}`,data:{insurance:this.modalData.insurance,costs:this.modalData.costs,doctorID:(this.selectedDoctor==="Brak"?null:this.selectedDoctor)}}
            await this.$store.commit("setData",payload)
            location.reload();
        },
       async setCost(){
           let payload = {type:"PUT",patch:`http://localhost:8080/api/Patients/updatePatient/${this.modalData.id}`,data:{insurance:this.modalData.insurance,costs:this.zaległość,doctorID:this.modalData.doctorID}}
            await this.$store.commit("setData",payload)
            //location.reload();
            this.modalData.costs=this.zaległość
        },
        hide(){
             this.$emit('close');
        },
         async openModal(id){
          checkAccess();
          await this.$store.commit("setModalData",id) 
          window.console.log("id :",id); 
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

#headers #last{
    padding-right: 90px;
    padding-left: 20px;
}

#headers a{
    margin-left: auto;
    margin-right: auto;
    padding-right: 0px;
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
    height: 380px;
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
    padding: 0px;
}

#Modal{
    background-image: none;
    background-color: #42bcf5;
    width: 100%;
    height: 100%;
    position: absolute;
}

#content{
    align-items: center;
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