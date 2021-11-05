<template>
  <div class="pa-4">
   
   <v-toolbar>
     <h1>Lista de Carros &nbsp &nbsp </h1>
   <v-btn 
        
        target="noUpperCase"
        color="primary"
        @click="newCar()"
    >
      <v-icon smal left>
        mdi-plus
      </v-icon>
         Agregar nuevo carro
    </v-btn>
    </v-toolbar>
    <br>
    <br>
 
    <div class="filterContainer"  >
    <v-text-field
        v-model="search"
        
        append-icon="mdi-magnify"
        label="Buscar automovil"
        hide-details
    />
    </div>
    <br>
    <br>
   <div>
     <v-data-table
          :search="search"
          :headers="headers"
          :items="localCars"
          :items-per-page="10"
          class="elevation-3"
        >
        <template v-slot:item.actions="{ item }">
            <v-btn
              class="ma-2"
              color="secondary"
              @click="editItem(item)"
              icon
            >
              <v-icon>mdi-pencil</v-icon>
            </v-btn>
            
            <v-btn
              class="ma-2"
              color="error"
              @click="deleteItem(item)"
            >
            <v-icon>mdi-trash-can</v-icon>
            </v-btn>
          </template>
     </v-data-table>
    </div>
  </div>  

</template>
<script>

  export default {
   name:"Cars",
      data(){
      return{
          products: [],
          localCars:[],
          search:'',
            headers: [
        {
          text: 'Marca',
          align: 'start',
          sortable: true,
          value: 'maker',
          class: 'primary--text',
        },
        { text: 'Modelo', value: 'model', class: 'primary--text' },
        { text: 'Año', value: 'year', class: 'primary--text' },
        { text: 'Color', value: 'color', class: 'primary--text' },
        { text: 'Precio', value: 'price',class: 'primary--text' },
        { text: 'Opciones', value: 'actions', sortable: false,class: 'primary--text' },
      ],
            }
        },
        created(){
          this.$http.get("car?filter=all")
          .then((result) => {
            this.localCars = result.body
          })
          .catch((error) => {
            
          });
        },
    methods: {
      newCar(){
        this.$router.push("/addCar");
      },
      getCars(){
        this.$http.get("car?filter=all")
          .then((result) => {
            this.localCars = result.body
          })
          .catch((error) => {
            
          });
      },
      editItem(item){
        this.$router.push("/addCar?id="+item.id);
      },
      deleteItem(item){
        this.$http.delete("car/"+item.id)
          .then((result) => {
            this.getCars()
          })
          .catch((error) => {
            
          });
      },
    }
  }



</script>