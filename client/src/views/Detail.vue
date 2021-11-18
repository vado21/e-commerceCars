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
<div >
  <v-container  >
          <v-row align="center" justify="center">
      <v-col>
    <h1>{{car.maker}} {{car.model}}</h1>

      <div class="my-4 text-subtitle-1">
        Precio: $ {{car.price}} MXN
      </div>

   <div class="my-4 text-subtitle-1">
        Puertas: {{car.numDoors}} 
      </div>
   <div class="my-4 text-subtitle-1">
       Llantas: {{car.numWheels}} 
      </div>

    <v-divider class="mx-4"></v-divider>
    <div class="my-4 text-subtitle-1">
       Color: {{car.color}} 
      </div>
    <div class="my-4 text-subtitle-1">
       Año: {{car.color}} 
      </div>
     <div class="my-4 text-subtitle-1">
       Marca: {{car.maker}} 
      </div>
    

    <v-img  class="imperial-image" :src="car.images[0]" alt="Imagen de la vela"></v-img>
     <v-divider class="mx-4"></v-divider>
    <v-card
    :loading="loading"
    class="mx-auto my-12"
    
  >
  <v-container>
      <v-card-title>Hacer Pedido</v-card-title>
      <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
  <form @submit.prevent="submit">
    <validation-provider
        name="Name"
        rules="required"
      >
      <v-text-field
            v-model="name"
            label="Nombre Completo"
            outlined
            clearable
          ></v-text-field>
       </validation-provider>
      <validation-provider
        name="Direccion"
        rules="required"
      >
      <v-text-field
            v-model="direccion"
            label="Direccion"
            outlined
            clearable
          ></v-text-field>
      </validation-provider>
      <validation-provider
        name="Telefono"
        rules="required"
      >
      <v-text-field
            v-model="telefono"
            label="Telefono"
            outlined
            clearable
          ></v-text-field>
       </validation-provider>
      <validation-provider
        name="Email"
        rules="required"
      >
      <v-text-field
            v-model="email"
            label="Email"
            outlined
            clearable
          ></v-text-field>
      </validation-provider>
      <v-btn
      class="white--text"
      color="deep-purple accent-4"
      :disabled="invalid"
      @click="createOrder()"
    >
      Hacer Pedido
    </v-btn>
    </form>
      </validation-observer>
      </v-container>

  </v-card>
  </v-col>
   </v-row>
        
        </v-container>
</div>

</div>
</template>
	



<script>
  import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
  import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
   import {CarService} from "../services/CarService";
   setInteractionMode('eager')
  extend('required', {
    ...required,
    message: '{_field_} can not be empty',
  })
   export default {
     components: {
      ValidationProvider,
      ValidationObserver,
    },
    name:"Cars",
       data(){
             return{
                 car:{},
                 products: [],
                 searchTerm: "",
                 invalid:true,
                 name:"",
                 direccion:"",
                 email:"",
                 telefono:"", 
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
    },
        createOrder(){
          const json = {
            carId: this.car.id,
            clientName:this.name,
            address: this.direccion,
            phone: this.telefono,
            email: this.email,
            status: "new"
          }
          this.$http.post("reservation/",json)
          .then((result) => {
            this.$router.push("/");
          })
          .catch((error) => {
            
          });
        }
      },

      created(){
        
        if(this.$route.query.id){
          
          this.$http.get("car/"+this.$route.query.id)
          .then((result) => {
            if(result){
              this.car = result.body
              console.log(result)
            }
          })
          .catch((error) => {
            this.$router.push("/");
          });

        }
        else{
          this.$router.push("/");
        }
       
     }
   }
</script>
