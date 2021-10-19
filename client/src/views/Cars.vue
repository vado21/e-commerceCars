<template>
  <div>
   <h1>Carros test</h1>
     <div class="col col-sm-2" v-for="product in products" v-bind:key="product._id">
      {{product}}
     </div>

  </div>  

</template>
<script>
   import {Car} from "../models/Car";
   import {CarService} from "../services/CarService";
  export default {
   name:"Cars",
      data(){
            return{
                products: []
            }
        },

     async created(){
      let data = await CarService.list()
                        .then( response => response.data)
                        .catch(err => console.error(err))
      this.products = data;
    }
  }


</script>