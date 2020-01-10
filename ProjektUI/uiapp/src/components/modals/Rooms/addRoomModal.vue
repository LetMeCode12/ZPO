<template>
    <div id="Modal">
        <div id="content">
        <div id="Header">
            <h1>Dodawanie Pokoju</h1>
            {{modalData}}
        </div>
        <div id='MainContent'>
        <input id="Input" type="number" v-model="nr_Room" placeholder="Numer Pokoju"/>
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
            nr_Room: '',
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
    created:function(){
           this.modalData=this.$store.getters.getData.find(e=>e.id===this.$store.getters.modalData).branches.find(e=>e.id===this.$store.getters.getBranchId);
           window.console.log("modalData:",this.modalData)
    },
    methods:{
        hide(){
            this.$emit('close');
        },
       async setData(){     
               
         let payload = {type:"PUT",patch:`http://localhost:8080/api/Buildings/updateBranch/addRoom/${this.$store.getters.modalData}/${this.modalData.id}`,data:{nr_Room:this.nr_Room, branchID:this.modalData.id}}
            window.console.log("pajlod:",payload);
        
           await this.$store.commit("setData",payload)
           await this.$store.commit("getData",this.path)
           await location.reload();
           await this.$emit('close'); 
         
        },
        
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
    margin-left: auto;
    margin-right: auto;
    margin-top:auto;
}


</style>