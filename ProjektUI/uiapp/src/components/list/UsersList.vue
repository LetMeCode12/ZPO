<template>
    <div id="list">
        <!-- wyszukiwanie tu -->
        <div id="contentList">
            
            <div id="headers">
             <a id="first"> # </a>  <a>Login</a> <a id="last"> Password </a>
            </div>
           
            <div id="row" v-for="(item,index) in data" v-bind:key="item">
                <a>{{index}}</a> <a id="center">{{item.login}}</a> <a>{{item.password}}</a> <a>{{item.specialization}}</a>
                <img id="icons" @click="_delete(item.idUser)" src="../../icons/trash-icon.svg"/>
            </div>
        </div>
    <modals-container/>
    </div>
</template>

<script>
import '../../icons/info-icon.svg'
import { checkAccess } from '../../seciurity/sciurityUtils';
import modifyDoctorsModal from'../modals/Doctors/modifyDoctorsModal';
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
          this.$modal.show(modifyDoctorsModal,{draggable: true},{height: "700px"})

        },
       async _delete(id){
            checkAccess();
            window.console.log(id)
            let payload = {patch:`http://localhost:8080/Users/delUsr/${id}`}
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
    padding: 0px;
    margin-left: auto;
    margin-right: auto;
}

#headers a{
    padding-left:0px;
    margin-right: auto;
    margin-left:auto;
    padding-right: 0vw;
}

#headers #last{
    padding-right: 6vw;
}

#headers #first{
    padding-left: 2vw;
    margin-left: 0px;
}
</style>