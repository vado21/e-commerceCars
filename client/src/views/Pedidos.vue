<template>
<div>
  <v-navigation-drawer  app>
      <navigation-bar/>
  </v-navigation-drawer >
  <div class="pa-4">
   
   <v-toolbar>
     <h1>Pedidos &nbsp &nbsp</h1>
     <v-btn
     @click="actualizar()" 
     >Actualizar</v-btn>
    </v-toolbar>
    <br>
    <br>
 
    <div class="filterContainer"  >
    <v-text-field
        v-model="search"
        
        append-icon="mdi-magnify"
        label="Buscar Pedido"
        hide-details
    />
    </div>
    <br>
    <br>
   <div>
     <v-data-table
          :search="search"
          :headers="headers"
          :items="pedidos"
          :items-per-page="10"
          class="elevation-3"
        >  
        <template v-slot:item.cstatus="{ item }">
          <v-simple-checkbox
            v-model="item.cstatus"
            @click="editPedido(item)"
            :ripple="false"
          ></v-simple-checkbox>
        </template>
     </v-data-table>
    </div>
    
  </div>  
</div>
</template>
<script>
import {ReservationService} from '../services/ReservationService'
import navigationBar from '../components/navigationBar.vue';
  export default {
    components: {
      navigationBar
    },
   name:"Pedidos",
      data(){
        return{
            products: [],
            pedidos:[],
            search:'',
            select: "",
            status: [],
            statusAux: [],
            headers: [
              { text: 'Card ID', value: 'cardId', class: 'primary--text' },
              { text: 'Nombre', value: 'clientName', class: 'primary--text' },
              { text: 'Dirección', value: 'address', class: 'primary--text' },
              { text: 'Telefono', value: 'phone',class: 'primary--text' },
              { text: 'Correo', value: 'email', class: 'primary--text' },
              { text: 'Status', value: 'status', class: 'primary--text', sortable: false},
              { text: 'Entregado', value: 'cstatus', class: 'primary--text', sortable: false },
            ],
          }
        },
        async created(){
          // this.pedidos = await ReservationService.list()
          let p2 = [
            {
              cardId: "123",
              clientName: "Nestor",
              address: "Calle 1, Colonia 1",
              phone: "12345678",
              email: "nestor@gmail.com",
              status: "Entregado",
              cstatus: true
            },
            {
              cardId: "456",
              clientName: "Alejandro",
              address: "Calle 2, Colonia 2",
              phone: "23456789",
              email: "alejandro@gmail.com",
              status: "No Entregado",
              cstatus: false
            },
            {
              cardId: "789",
              clientName: "Juan",
              address: "Calle 3, Colonia 3",
              phone: "34567891",
              email: "juan@gmail.com",
              status: "Entregado",
              cstatus: true
            },
            {
              cardId: "123",
              clientName: "Diego",
              address: "Calle 4, Colonia 4",
              phone: "45678912",
              email: "diego@gmail.com",
              status: "No Entregado",
              cstatus: false
            },
          ]
          this.pedidos = p2;
          this.status = this.pedidos.map(function(Arr){
            return Arr.cstatus;
          })
         
        },
    methods: {
     editPedido(item){
       if(item.cstatus == true){
         item.status = "Entregado";
          console.log( this.pedidos[0]);
       }
       else{
         item.status = "No Entregado";
        console.log( this.pedidos[0]);
       }
     },
     actualizar(){
        this.statusAux = this.pedidos.map(function(Arr){
            return Arr.cstatus;
          })

           console.log(this.statusAux)

          for(var i = 0; i<this.pedidos.length; i++){
            if(this.status[i] != this.statusAux[i]){
              console.log("Actualizar", this.pedidos[i].cardId)
            }
          }
         
     }
    }

  }
</script>
