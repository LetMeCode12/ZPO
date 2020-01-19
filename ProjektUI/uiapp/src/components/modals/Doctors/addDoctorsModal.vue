<template>
    <div id="Modal">
        <div id="content">
        <div id="Header">
            <h1>Dodawanie Lekarza</h1>
        </div>
        <div id='MainContent'>
        <input id="Input" v-model="namee" placeholder="Imie"/>
        <br/>
        <input id="Input" v-model="surrname" placeholder="Nazwisko"/>
        <br/>
        <input id="Input" v-model="specialization" type="text" placeholder="Specializacja"/>
        <br/>
         <select id="select" v-model="selectedBranch">
        <option>Brak</option>
        <option v-for="item in branches" v-bind:key="item" v-bind:value="item.id">{{item.branch_Name}}</option>
        </select>
        </div>
        <div id="footer">
        <button id="Button" @click="setData">Dodaj</button>
        <button id="Button" @click="hide">Zamknij</button>
        </div>
        
        </div>
    </div>
</template>

<script>
import {getData} from '../../../seciurity/sciurityUtils'
export default {

    data () {
        return {
            adress: '',
            namee: '',
            surrname:"",
            pesel:"",
            birth:"",
            selected:'',
            branches:"",
            selectedBranch:"",
        }
    },
    props:{
        name:{
            default:""
        },
        path:{
            default:"http://localhost:8080/api/Buildings/getAll"
        }
    },
     created: async function(){
        let payload = `http://localhost:8080/api/Buildings/getAllBranch`

        
          // this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData);
        this.branches=await getData(payload)

    
        window.console.log("branch:",this.branches)
    },
    methods:{
        hide(){
            this.$emit('close');
        },
       async setData(){         
         let payload = {patch:"http://localhost:8080/api/Doctors/addDoctor",data:{name:this.namee,surrname:this.surrname,specialization:this.specialization,branchID:(this.selectedBranch==="Brak"? null:this.selectedBranch)}}
           window.console.log("XDD:",payload)
           
           await this.$store.commit("setData",payload)
           await this.$store.commit("getData",this.path)
           await location.reload();
           await this.$emit('close'); 
         
        }
    }
}
</script>

<style scoped>
*{
    background-image: none;
}

#Header{
    position: relative;
    text-align: center;
    
}

#footer{
    position:relative;
    align-items: center;
    bottom: -20px; 
    display: flex;
}

#Button{
    margin-right: auto;
    margin-left: auto; 
}

#MainContent{
   top:20px;
   position: relative;
   display: grid;
   align-items: center;
   text-align: center;
}

#select{
    float: left;
}

#MainContent select{
    width:auto;
    appearance: none;
    margin-right: auto;
    margin-left: auto; 
    border-radius: 2px;
    text-align: center;
    background-color: azure;
}

#Input{
  margin-right: auto;
  margin-left: auto;  
  margin-bottom: 20px;
  margin-top:20px;
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
    height: 430px;
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