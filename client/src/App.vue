<template>
  <v-app>
    <v-navigation-drawer app>
      <navigation-bar/>
    </v-navigation-drawer >
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
};
</script>
