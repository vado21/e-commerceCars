<template>
  <v-card
    height="100%"
    width="300"
  >
    <v-navigation-drawer
      absolute
      dark
      src="https://cdn.vuetifyjs.com/images/backgrounds/bg-2.jpg"
      width="100%"
      permanent
    >
      <v-list>
        <v-list-item
          v-for="([icon, text, path], i) in items"
          :key="i"
          @click="goTo(path)"
          
        >
          <v-list-item-icon>
            <v-icon>{{ icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ text }}</v-list-item-title>
          </v-list-item-content>
          
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>


<script>
  export default {
    data: () => ({
      items: [
        ['mdi-car-estate', 'Carros','/Cars'],
        ['mdi-account-supervisor-circle', 'Pedidos','/Pedidos'],
        ['mdi-logout','Cerrar Sesion','/logout']
      ],
    }),
    methods:{
      logout(){
        localStorage.clear('usuario')
        this.$router.push("/");
      },
      goTo(path){
        if(path == '/logout'){
          localStorage.clear('usuario')
          this.$router.push("/");
        }
        else{
          this.$router.push(path);
        }
      }
    }
  }
</script>

<style scoped>


</style>