<template>
<div id="Modal">
    <div id="content">
    <div id="header"><h1>Patient</h1></div>
    <div id="topcontent">
        <!-- <a>Adress :{{modalData}}</a> -->
    <br/>
    <a>Imie :{{modalData.name}}</a>
    <br/>
    <a>Nazwisko :{{modalData.surrname}}</a>
    <br/>
    <a>Pesel :{{modalData.pesel}}</a>
    <br/>
    <a>Data urodzenia :{{new Date(modalData.birth).getDate()}}-{{new Date(modalData.birth).getMonth()+1}}-{{new Date(modalData.birth).getFullYear()}}r</a>
    <br/>
    <a>Data rejestracji :{{new Date(modalData.dateOfAdmission).getDate()}}-{{new Date(modalData.dateOfAdmission).getMonth()+1}}-{{new Date(modalData.dateOfAdmission).getFullYear()}}r</a>
    <br/>
    <a>Ubezpieczenie :{{(modalData.insurance?"Tak":"Nie")}} <button id="Button" @click="change">Zmień</button> </a>
    <br/>
    <a>Zaległości :{{modalData.costs}} zł</a>
    <br/>
    <a>Posiada łóżko :{{(modalData.bedID?"Tak":"Nie")}}</a>
    <br/>
    <a>Przypisany do lekarza :{{(modalData.doctorID?this.doctors.find(e=>e.id===modalData.doctorID).name:"Nie")}} {{(modalData.doctorID?this.doctors.find(e=>e.id===modalData.doctorID).surrname:"")}}</a>
     <br/>
         Dodawanie Zaległości :
     
    <input id="Input" placeholder="Dodaj zaległość" type="number" v-model="zaległość"/>
    
    <button id="Button" @click="setCost">Dodaj Zaległości</button>
    <br/>
    Dodawanie Lekarza :
    <select id="select" v-model="selectedDoctor">
        <option>Brak</option>
        <option v-for="item in doctors" v-bind:key="item" v-bind:value="item.id">{{item.name}} {{item.surrname}} {{item.specialization}}</option>
    </select>
    <button id="Button" v-if="selectedDoctor" @click="findData">Dodaj Lekarza</button>
       <br/>
        Dodoawanie Łóżka :
       <br/>
    <select id="select" v-model="selectedBuilding">
        <option v-for="item in buildings" v-bind:key="item" v-bind:value="item">Nr Budynku: {{item.nr_Budynku}}, Ulica: {{item.address}}</option>
    </select>
    <br/>
    <select id="select" v-if="selectedBuilding" v-model="selectedBranch">
        <option v-for="item in selectedBuilding.branches" v-bind:key="item" v-bind:value="item">Nr Oddziału: {{item.nr_Branch}}, Oddział: {{item.branch_Name}}</option>
    </select>
    <br/>
    <select id="select" v-if="selectedBranch" v-model="selectedRoom">
        <option v-for="item in selectedBranch.rooms" v-bind:key="item" v-bind:value="item">Nr Pokoju: {{item.nr_Room}}</option>
    </select>
    <br/>
    <select id="select" v-if="selectedRoom" v-model="selectBed">
        <option>Brak</option>
        <option v-for="item in selectedRoom.beds" v-bind:key="item" v-bind:value="item.idBed">{{(!item.idPatient?`Nr Łóżka: ${item.nrBed}`:null)}}</option>
    </select>
    <br/>
    <button id="Button" v-if="selectedRoom" @click="addBed">Dodaj Łóżko</button>
    </div> 
    
    
<div id="footer">
        <!-- <button id="Button" @click="setData">Dodaj</button> -->
        <button id="Button" @click="hide">Zamknij</button>
    </div>
</div>
</div>
</template>

<script>
import modifyBranchModal from "../Branches/modifyBranchModal";
import { checkAccess, getData} from '../../../seciurity/sciurityUtils';
import addBranchModalVue from '../Branches/addBranchModal.vue';
export default {
    data(){
        return{
            modalData:"NoData",
            zaległość:0,
            doctors:[],
            selectedDoctor:"",
            selectedBuilding:"",
            selectedBranch:"",
            patients:"",
            buildings:[],
            branches:[],
            selectedRoom:"",
            selectBed:""
        }
    },
    created: async function(){
        let payload = `http://localhost:8080/api/Doctors/getDoctors`
        let payload2 = `http://localhost:8080/api/Patients/getAll`
        let payload3=  `http://localhost:8080/api/Buildings/getAll`
        
          // this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData);
        this.doctors=await getData(payload)
        this.patients=await getData(payload2)
        this.buildings = await getData(payload3)
        this.modalData = this.patients.find(e=>e.id===this.$store.getters.modalData);
        window.console.log("patients:",this.modalData)
        window.console.log("doctorsy:",this.doctors)
        window.console.log('Buildings',this.buildings);
    },
    methods:{
        async addBed(){
            window.console.log("lóżko:", this.selectBed)
            let payload = {type:"PUT",patch:`http://localhost:8080/api/Patients/addPatientToBed/${this.modalData.id}/${this.selectBed}`}
            await this.$store.commit("setData",payload)
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
            window.console.log("XDD",this.selectedBuilding)
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