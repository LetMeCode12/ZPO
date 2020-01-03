<template>
    <div id="Modal">
        <div id="content">
        <div id="Header">
            <h1>Dodawanie Budynku</h1>
        </div>
        <div id='MainContent'>
        <input id="Input" v-model="adress" placeholder="Ulica"/>
        <br/>
        <input id="Input" v-model="nrBuilding" placeholder="Numer Budynku"/>
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
            nrBuilding: '',
        }
    },
    props:{
        name:{
            default:"ModalBudynki"
        },
        path:{
            default:"http://localhost:8080/api/Buildings/getAll"
        }
    },
    methods:{
        hide(){
            this.$emit('close');
        },
        setData(){
            let payload = {patch:"http://localhost:8080/api/Buildings/addBuilding",data:{nr_Budynku:this.nrBuilding,address:this.adress}}
            this.$store.commit("setData",payload)
            this.$store.commit("getData",this.path)
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
    bottom: -100px; 
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
    height: 380px;
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

}


</style>