<template>
  <div :style="myColor" id="app">
    hello{{value.val}}
    <input  v-model="myColor.backgroundColor"/>
    <button @click="onClick"/>
    <button @click="onClear">Clear</button>
    
  </div>
</template>

<script>

export default {
  name: 'App',
  data(){
    return{
      value:{
        val:"Word"
      },
      valueLocal:{
        val:localStorage.getItem('value1')
      },
      myColor:{
         backgroundColor:"#fff00",
      },
     

      
    }
  },
  methods:{
  onClick(){
   
    localStorage.setItem("value1",{value:20})
   alert("Hello")
  
  },
  onClear(){
    localStorage.clear();
  }
  }
 
}
</script>

<style  scoped>
#app {
  font-family:'Courier New', Courier, monospace;
  background-color: 'Color'
}
</style>
