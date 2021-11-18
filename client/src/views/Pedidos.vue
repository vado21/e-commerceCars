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
          :items="p2"
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
            p2: [],
            p3: [],
            headers: [
              { text: 'Car ID', value: 'carId', class: 'primary--text' },
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
           this.$http.get("reservation?filter=all")
            .then((result) => {
              this.pedidos = result.body;
              this.p2 = result.body;
              for(var i=0; i<this.p2.length; i++){
                if(this.p2[i].status == "new" || this.p2[i].status == null){
                  this.p2[i]["status"] = "new";
                  this.p2[i].cstatus = false;
              }
              else{
                this.p2[i].status = "complete";
                this.p2[i].cstatus = true;
              }
            }
            })
            .catch((error) => {
              
            });

          this.status = this.pedidos.map(function(Arr){
            return Arr.cstatus;
          })
         
        },
    methods: {
     editPedido(item){
       if(item.cstatus == true){
         item.status = "complete";
       }
       else{
         item.status = "new";
       }
     },
     actualizar(){

       for(var i=0; i<this.pedidos.length; i++){
         this.$http.post("reservation/",this.pedidos[i]);
       }

       alert("Base de datos actualizada");
     }
    }

  }
</script>
