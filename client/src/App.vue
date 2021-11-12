<template>
  <div >
    <v-app-bar
      color="deep-purple accent-4"
      dark
      dense
    >

      <v-toolbar-title>Tienda Virtual de Carros</v-toolbar-title>

      <v-spacer></v-spacer>
        
      
    </v-app-bar>
    <v-navigation-drawer v-show="false" app>
      <navigation-bar/>
    </v-navigation-drawer >
    <v-content>
      <router-view/>
    </v-content>
  </div>
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
};
</script>
