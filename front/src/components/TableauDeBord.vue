<template>

  <div class="container" id="inTableauDeBord">
      <h1>Bienvenue</h1>
      <a v-bind:href="logoutUrl">Déconnection</a>
  </div>

</template>


<script>

const START_URL = 'http://localhost:9000';
const API_URL = START_URL + '/api';
const APP_URL_START = START_URL + '/app'
const TABLEAU_DE_BORD_URL = APP_URL_START + '/tableau-de-bord'
const axios = require('axios');

export default {
   data :function() {
    return {
      logoutUrl: APP_URL_START + '/logout',
    }
  }
}
</script>
