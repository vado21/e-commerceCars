<template>
<div style="display: flex; padding: 20px; justify-content: space-between;">
    <div style="padding:20px" v-for="product in products" v-bind:key="product._id">
		<template>
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
        @click="reserve"
      >
        Ver detalle
      </v-btn>
    </v-card-actions>
  </v-card>

</template>
	</div>
</div>
</template>

<script>

   import {CarService} from "../services/CarService";
   export default {
    name:"Cars",
       data(){
             return{
                 products: []
             }
         },

      async created(){
       this.products = await CarService.list()
                         .then( response => response.data)
                         .catch(err => console.error(err))
     }
   }
</script>
