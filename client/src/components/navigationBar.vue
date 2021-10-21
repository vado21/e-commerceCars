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
          link
          :to="path"
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
        ['mdi-email', 'Galería','/Gallery'],
        ['mdi-email', 'Carros','/Cars'],
        ['mdi-account-supervisor-circle', 'Pedidos','/Pedidos'],
      ],
    }),
  }
</script>

<style scoped>


</style>