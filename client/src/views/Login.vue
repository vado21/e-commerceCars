<template>
  <div><span class="bg"></span>
  <div >
    
    <v-card
    :loading="loading"
    class="mx-auto my-12"
    max-width="374"
  >
    <template slot="progress">
      <v-progress-linear
        color="deep-purple"
        height="10"
        indeterminate
      ></v-progress-linear>
    </template>
    <v-card-actions class="justify-center">
    <v-card-title class="text-center" >Iniciar Sesion</v-card-title>
    </v-card-actions>
    <v-divider class="mx-4"></v-divider>
    <v-card-text>
      

      <div class="my-4 text-subtitle-1">
        <v-text-field
            v-model="email"
            filled
            :rules="[rules.required]"
            label="Usuario"
            clearable
          ></v-text-field>

        <v-text-field
            v-model="password"
            filled
            clearable
            label="Password"
            :type="'password'"
            :rules="[rules.required]"
          ></v-text-field>
          
          <v-card-actions class="justify-center">
            
        <p>{{message}}</p>
        </v-card-actions>
          <v-card-actions class="justify-center"> 
        <v-btn
          depressed
          color="primary"
          @click="iniciarSesion()"
        >
          Iniciar Sesion
        </v-btn>
        </v-card-actions>
      </div>

    </v-card-text>

  </v-card>
  </div>
  </div>
</template>

<script>
  import HelloWorld from '../components/HelloWorld'

  export default {
    name: 'Home',
    data () {
      return {
        title: 'Preliminary report',
        message:"",
        email: '',
        password:'',
        rules: {
          required: value => !!value || 'Required.',
          counter: value => value.length <= 20 || 'Max 20 characters',
          email: value => {
            const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return pattern.test(value) || 'Invalid e-mail.'
          },
        },
      }
    },
    components: {
      HelloWorld,
    },
    methods:{
      iniciarSesion(){
        if(this.email == "Admin123" && this.password == "password123"){
            localStorage.setItem('usuario', true);
            this.$router.push("/Cars");
        }
        else{
          this.message = "Datos invalidos"
        }
      }
    },
    created(){
      if(localStorage.getItem('usuario')){
        this.$router.push("/Cars");
      }
    }
  }
</script>

<style scoped>
.bg {
    width: 100%;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    background: url( 'https://images.unsplash.com/photo-1493238792000-8113da705763?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=870&q=80') no-repeat center center;
    background-size: cover;
    background-color: red;
  }
</style>