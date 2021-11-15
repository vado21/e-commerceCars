<template>
  <v-app>
  
    
    <v-content>
      <router-view/>
    </v-content>
  
  </v-app>
</template>

<script>
import navigationBar from './components/navigationBar.vue';
export default {
  name: 'App',

  data: () => ({
    //
  }),
   components: {
    navigationBar,
  },
  created(){

  },
  methods:{
    goHome(){
      this.$router.push("/");
    },
    goAdmin(){
       this.$router.push("/addCar");
    }
  }
};
</script>
<style scoped>

</style>
