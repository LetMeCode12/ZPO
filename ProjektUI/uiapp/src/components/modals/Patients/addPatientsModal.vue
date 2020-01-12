<template>
    <div id="Modal">
        <div id="content">
        <div id="Header">
            <h1>Dodawanie Pacjenta</h1>
        </div>
        <div id='MainContent'>
        <input id="Input" v-model="namee" placeholder="Imie"/>
        <br/>
        <input id="Input" v-model="surrname" placeholder="Nazwisko"/>
        <br/>
        <input id="Input" v-model="pesel" type="number" placeholder="Pesel"/>
        <br/>
        <a>Data urodzenia:</a>
        <input id="Input" v-model="birth" type='date' placeholder="Data urodzenia"/>
        <br/>
        <input id="Input" v-model="adress" placeholder="Adress"/>
        <div id="select">
        Ubezpieczony :
        <select v-model="selected">
            <option>Tak</option>
            <option>Nie</option>
        </select>
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

export default {
    data () {
        return {
            adress: '',
            namee: '',
            surrname:"",
            pesel:"",
            birth:"",
            selected:''
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
    methods:{
        hide(){
            this.$emit('close');
        },
       async setData(){         
         let payload = {patch:"http://localhost:8080/api/Patients/addPatient",data:{name:this.namee,surrname:this.surrname,pesel:this.pesel,birth:new Date(this.birth).getTime(),address:this.adress,insurance:(this.selected==="Tak"? true:false)}}
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
    width:27px;
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
    height: 580px;
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