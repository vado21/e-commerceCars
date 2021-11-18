		<template>
      
      <div>
        
    <v-app-bar
      color="deep-purple accent-4"
      dark
      dense
      
    >
    <v-btn color="red accent-4" @click="goHome()" ><v-icon>mdi-home</v-icon></v-btn>

      <v-toolbar-title> &nbsp &nbsp Tienda Virtual de Carros</v-toolbar-title>

      <v-spacer></v-spacer>
        <v-btn color="red accent-4" @click="goAdmin()" >Administrador</v-btn>
      <v-menu
        left
        bottom
      >        
      </v-menu>
    </v-app-bar>
        <br>
        <v-container  >
          <v-row align="center" justify="center">
      <v-col><v-text-field
            v-model="searchTerm"
            filled
            label="Buscar Auto"
            clearable
          ></v-text-field></v-col>
   </v-row>
        
        </v-container>
  <div style="display: flex; flex-wrap: wrap;">
  <div style="padding:20px" v-for="product in filterByTerm" v-bind:key="product._id">
  <v-card
    class="mx-auto my-12"
    max-width="374"
  >
	<v-img  class="imperial-image" :src="product.images[0]" alt="Imagen de la vela"></v-img>

    <v-card-title>{{product.maker}} {{product.model}}</v-card-title>

    <v-card-text>

      <div class="my-4 text-subtitle-1">
        $ {{product.price}} MXN
      </div>

      <div>Small plates, salads & sandwiches - an intimate setting with 12 indoor seats plus patio seating.</div>
    </v-card-text>

    <v-divider class="mx-4"></v-divider>

    <v-card-title>Cotizalo ahora mismo</v-card-title>

    <v-card-text>
      <v-chip-group
        v-model="selection"
        active-class="deep-purple accent-4 white--text"
        column
      >
        <v-chip>{{product.color}}</v-chip>
        <v-chip>{{product.year}}</v-chip>
        <v-chip>{{product.maker}}</v-chip>
      </v-chip-group>
    </v-card-text>

    <v-card-actions>
      <v-btn
        color="deep-purple lighten-2"
        text
        @click="goToCar(product.id)"
      >
        Ver detalle
      </v-btn>
    </v-card-actions>
  </v-card>
</div>
</div>
</div>
</template>
	



<script>

   import {CarService} from "../services/CarService";
   export default {
    name:"Cars",
       data(){
             return{
                 products: [],
                 searchTerm: "" 
             }
         },
      computed: {
    filterByTerm() {
      return this.products.filter(car => {
        return car.maker.toLowerCase().includes(this.searchTerm);
      });
    },
      },
      methods:{
        goToCar(id){
          this.$router.push("/Detail?id="+id);
        },
        goHome(){
      this.$router.push("/");
    },
    goAdmin(){
       this.$router.push("/Login");
    }
      },
       created(){
        this.$http.get("car?filter=all")
            .then((result) => {
               this.products = result.body
            })
            .catch((error) => {
              
            });
     }
   }
</script>

<style scoped>
.wrapper {
  
  justify-content: center;
}
</style>
