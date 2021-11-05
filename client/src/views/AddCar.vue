<template>
  <div class="pa-4">
   
   <v-toolbar>
     <h1>Agregar Carro</h1>
    </v-toolbar>
    <br>
    <br>
    <p>Seleccionar tipo de carro:</p>
    <v-select
          v-model="select"
          :items="items"
          :error-messages="errors"
          label="Tipo de Carro"
          data-vv-name="select"
          v-on:change="changeSelect(`${select}`)"
    ></v-select>
    
    <div v-show="selectSen">
  <v-container >
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
          v-model="llantas"
          label="Numero de llantas"
          type="number"
          required
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Puertas"
        rules="required"
      >
    <v-text-field
          v-model="puertas"
          label="Numero de Puertas"
          type="number"
          outlined
          required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="marca"
          label="Marca"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="modelo"
          label="Modelo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="year"
          label="Año"
          type="number"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="color"
          label="Color"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="precio"
          label="Precio"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="tipo"
          label="Tipo"
          outlined
        ></v-text-field>
    </validation-provider>
    <v-btn
      class="ma-2"
      color="blue"
      @click="addImage()"
    >
     <v-icon>mdi-plus-box</v-icon> Agregar Imagen
    </v-btn>
    <ul id="example-1">
      <li v-for="(item, index) in listaImagenes">
        <v-text-field
              v-model="listaImagenes[index]"
            ></v-text-field>
      </li>
    </ul>
    <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
        color="success"
        @click="newCar(1)"
      >
        Guardar
      </v-btn>
      </form>
      </validation-observer>
    </v-container>
    </div>

    <div v-show="selectLuju">
  <v-container >
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
          v-model="llantas"
          label="Numero de llantas"
          type="number"
          required
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Puertas"
        rules="required"
      >
    <v-text-field
          v-model="puertas"
          label="Numero de Puertas"
          type="number"
          outlined
          required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="marca"
          label="Marca"
          outlined
          required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Modelo"
        rules="required"
      >
    <v-text-field
          v-model="modelo"
          label="Modelo"
          outlined
          required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Año"
        rules="required"
      >
    <v-text-field
          v-model="year"
          label="Año"
          type="number"
          outlined
          required
        ></v-text-field>
     </validation-provider>
     <validation-provider
        name="Color"
        rules="required"
      >
    <v-text-field
          v-model="color"
          label="Color"
          outlined
          required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Precio"
        rules="required"
      >
    <v-text-field
          v-model="precio"
          label="Precio"
          type="number"
           
           outlined
           required
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Tipo"
        rules="required"
      >
    <v-text-field
          v-model="tipo"
          label="Tipo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Carbono"
        rules="required"
      >
    <v-select
          v-model="fibra"
          :items="fibraCarbono"
          :error-messages="errors"
          label="Fibra de Carbono"
    ></v-select>
    </validation-provider>
    <validation-provider
        name="Carbono"
        rules="required"
      >
    <v-select
          v-model="exoticCars"
          :items="fibraCarbono"
          :error-messages="errors"
          label="Puertas Exoticas"
    ></v-select>
    </validation-provider>
    <validation-provider
        name="Origen"
        rules="required"
      >
    <v-text-field
          v-model="origen"
          label="Origen"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="HP"
        rules="required"
      >
    <v-text-field
          v-model="hp"
          label="HP"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <v-btn
      class="ma-2"
      color="blue"
      @click="addImage()"
    >
     <v-icon>mdi-plus-box</v-icon> Agregar Imagen
    </v-btn>
    <ul id="example-1">
      <li v-for="(item, index) in listaImagenes">
        <v-text-field
              v-model="listaImagenes[index]"
            ></v-text-field>
      </li>
    </ul>
    <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
        color="success" 
        @click="newCar(2)"
      >
        Guardar
      </v-btn>
      </form>
      </validation-observer>
    </v-container>
    </div>
    <div v-show="selectCom">
  <v-container >
    <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
  <form @submit.prevent="submit">
    <validation-provider
        name="llantas"
        rules="required"
      >
    <v-text-field
          v-model="llantas"
          label="Numero de llantas"
          type="number"
          max-width="374"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Puertas"
        rules="required"
      >
    <v-text-field
          v-model="puertas"
          label="Numero de Puertas"
          type="number"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="marca"
          label="Marca"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Modelo"
        rules="required"
      >
    <v-text-field
          v-model="modelo"
          label="Modelo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Año"
        rules="required"
      >
    <v-text-field
          v-model="year"
          label="Año"
          type="number"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Color"
        rules="required"
      >
    <v-text-field
          v-model="color"
          label="Color"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Precio"
        rules="required"
      >
    <v-text-field
          v-model="precio"
          label="Precio"
          type="number"
           
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Tipo"
        rules="required"
      >
    <v-text-field
          v-model="tipo"
          label="Tipo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Tipo"
        rules="required"
      >
    <v-text-field
          v-model="volumen"
          label="Volumen de Espacio"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Tipo"
        rules="required"
      >
    <v-text-field
          v-model="peso"
          label="Maximo Peso"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Tipo"
        rules="required"
      >
    <v-text-field
          v-model="motor"
          label="Motor"
           outlined
        ></v-text-field>
    </validation-provider>
    <v-btn
      class="ma-2"
      color="blue"
      @click="addImage()"
    >
     <v-icon>mdi-plus-box</v-icon> Agregar Imagen
    </v-btn>
    <ul id="example-1">
      <li v-for="(item, index) in listaImagenes">
        <v-text-field
              v-model="listaImagenes[index]"
            ></v-text-field>
      </li>
    </ul>
    <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
        color="success" 
        @click="newCar(3)"
      >
        Guardar
      </v-btn>
      </form>
      </validation-observer>
    </v-container>
    </div>
    <div v-show="selectBlin">
  <v-container >
    <validation-observer
    ref="observer"
    v-slot="{ invalid }"
  >
  <form @submit.prevent="submit">
    <validation-provider
        name="llantas"
        rules="required"
      >
    <v-text-field
          v-model="llantas"
          label="Numero de llantas"
          type="number"
          max-width="374"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Puertas"
        rules="required"
      >
    <v-text-field
          v-model="puertas"
          label="Numero de Puertas"
          type="number"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Marca"
        rules="required"
      >
    <v-text-field
          v-model="marca"
          label="Marca"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Modelo"
        rules="required"
      >
    <v-text-field
          v-model="modelo"
          label="Modelo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Año"
        rules="required"
      >
    <v-text-field
          v-model="year"
          label="Año"
          type="number"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Color"
        rules="required"
      >
    <v-text-field
          v-model="color"
          label="Color"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Precio"
        rules="required"
      >
    <v-text-field
          v-model="precio"
          label="Precio"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Precio"
        rules="required"
      >
    <v-text-field
          v-model="tipo"
          label="Tipo"
          outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Nivel"
        rules="required"
      >
    <v-text-field
          v-model="nivel"
          label="Nivel"
          type="number"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Fabrica"
        rules="required"
      >
    <v-text-field
          v-model="fabrica"
          label="Fabrica Certificada"
           outlined
        ></v-text-field>
    </validation-provider>
    <validation-provider
        name="Licencia"
        rules="required"
      >
    <v-text-field
          v-model="licencia"
          label="Licencia"
           outlined
        ></v-text-field>
    </validation-provider>
     <v-btn
      class="ma-2"
      color="blue"
      @click="addImage()"
    >
     <v-icon>mdi-plus-box</v-icon> Agregar Imagen
    </v-btn>
    <ul id="example-1">
      <li v-for="(item, index) in listaImagenes">
        <v-text-field
              v-model="listaImagenes[index]"
            ></v-text-field>
      </li>
    </ul>
    <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
        color="success"
        @click="newCar(4)"
      >
        Guardar
      </v-btn>
      </form>
      </validation-observer>
    </v-container>
    </div>
    <br>
   
  </div>  

</template>
<script>
  import { required, digits, email, max, regex } from 'vee-validate/dist/rules'
  import { extend, ValidationObserver, ValidationProvider, setInteractionMode } from 'vee-validate'
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
          indexImage:0,
          listaImagenes:[],
          llantas:'',
          puertas:'',
          marca:'',
          modelo:'',
          year:'',
          color:'',
          precio:'',
          tipo:'',
          fibra:'',
          volumen:'',
          peso:'',
          motor:'',
          name:'',
          nivel:'',
          fabrica:'',
          invalid:true,
          exoticCars:'',
          licencia:'',
          origen:'',
          hp:'',
          selectSen: true,
          selectLuju: false,
          selectCom: false,
          selectBlin: false,
          fibraCarbono:['Si','No'],
          select:'Sencillo',
          items:['Sencillo','Lujurioso','Comercial','Blindado'],
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
      submit () {
        this.$refs.observer.validate()
      },
      addImage(){
        
        this.listaImagenes.push('')
      },
      newCar(tipo){
        if(tipo == 1){
          const JsonBody ={
            numWheels: this.llantas,
            numDoors: this.puertas,
            maker: this.marca,
            model: this.modelo,
            status: true,
            year: this.year,
            images: this.listaImagenes,
            color: this.color,
            price: this.precio,
            type: this.type
          };
          
          this.$http.post("car/",JsonBody)
          .then((result) => {
            this.$router.push("/Cars");
          })
          .catch((error) => {
            
          });
        }
        else if(tipo == 2){
          let fibra = false;
          let exoticDoors = false;
          if (this.fibra == 'Si'){
            fibra = true
          }
          if (this.exoticDoors == 'Si'){
            exoticDoors = true
          }
          const JsonBody ={
            numWheels: this.llantas,
            numDoors: this.puertas,
            maker: this.marca,
            model: this.modelo,
            status: true,
            year: this.year,
            images: this.listaImagenes,
            color: this.color,
            price: this.precio,
            type: this.type,
            fiberCarbon: fibra,
            exoticDoors: exoticDoors,
            origen : this.origen,
            hp: this.hp
          };
          
          this.$http.post("luxury/",JsonBody)
          .then((result) => {
            this.$router.push("/Cars");
          })
          .catch((error) => {
            
          });
        }
        else if(tipo == 3){

          const JsonBody ={
            numWheels: this.llantas,
            numDoors: this.puertas,
            maker: this.marca,
            model: this.modelo,
            status: true,
            year: this.year,
            images: this.listaImagenes,
            color: this.color,
            price: this.precio,
            type: this.type,
            spaceVolume: this.volumen,
            maxWeightCargo: this.peso,
            motor: this.motor
          };

          this.$http.post("commercial/",JsonBody)
          .then((result) => {
            this.$router.push("/Cars");
          })
          .catch((error) => {
            
          });

        }
        else if(tipo == 4){
          const JsonBody ={
            numWheels: this.llantas,
            numDoors: this.puertas,
            maker: this.marca,
            model: this.modelo,
            status: true,
            year: this.year,
            images: this.listaImagenes,
            color: this.color,
            price: this.precio,
            type: this.type,
            level: this.nivel,
            certifiedFactory: this.fabrica,
            license: this.licencia
          };

          this.$http.post("armored/",JsonBody)
          .then((result) => {
            this.$router.push("/Cars");
          })
          .catch((error) => {
            
          });
        }
        
      },
      getCars(){
        this.$http.get("car?filter=all")
          .then((result) => {
            this.localCars = result.body
          })
          .catch((error) => {
            
          });
      },
      deleteItem(item){
        this.$http.delete("car/"+item.id)
          .then((result) => {
            this.getCars()
          })
          .catch((error) => {
            
          });
      },
      changeSelect(item){
        if (item == 'Sencillo'){
          this.selectLuju = false
          this.selectCom = false
          this.selectBlin = false
          this.selectSen = true
        }
        else if (item == 'Lujurioso'){
          this.selectCom = false
          this.selectBlin = false
          this.selectSen = false
          this.selectLuju = true
          
        }
        else if (item == 'Comercial'){
          this.selectBlin = false
          this.selectSen = false
          this.selectLuju = false
          this.selectCom = true
        }
        else if (item == 'Blindado'){
          this.selectSen = false
          this.selectLuju = false
          this.selectCom = false
          this.selectBlin = true
        }
      },
      
    }
  }



</script>