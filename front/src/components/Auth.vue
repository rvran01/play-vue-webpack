<template>

  <div id="fullscreen_bg" class="fullscreen_bg">

<div class="container" id="example-1">
      <h1>Authentification</h1>
      <!--a class="btn btn-primary" v-on:click="getQuote()">Check</a>
      <div class="quote-area" v-if="quote">
        <h2><blockquote>{{ quote }}</blockquote></h2>
      </div>


      <a v-bind:href="linkTableauDeBord">Redirection</a>
      <br/-->
        <form class="form-signin">
          <input type="text" v-model="cLogin" class="form-control" placeholder="LOGIN"/>
          <input type="password" v-model="cPassword" class="form-control" placeholder="MOT DE PASSE"/>
          <button type="button" class="btn btn-primary btn-block" v-on:click.prevent="validateAuthent">Valider</button>
          <br/>

          <div class="alert alert-error" role="alert" v-show="enErreurAuth">{{messageErreurAuth}}</div>

        </form>

        <!--child v-bind:mymessage="parentMsg"></child -->

    </div>

  </div>

</template>

<style>

.alert-error{
  color: #721c24;
  background-color: #ce3b5d;
  border-color: #ce3b5d;

}
.fullscreen_bg {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-size: cover;
    background-position: 50% 50%;
    background-image: url('http://cleancanvas.herokuapp.com/img/backgrounds/color-splash.jpg');
    background-repeat:repeat;
  }
  .form-signin {
    max-width: 280px;
    padding: 15px;
    margin: 0 auto;
      margin-top:50px;
  }
  .form-signin .form-signin-heading, .form-signin {
    margin-bottom: 10px;
  }
  .form-signin .form-control {
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
  }
  .form-signin .form-control:focus {
    z-index: 2;
  }
  .form-signin input[type="text"] {
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
    border-top-style: solid;
    border-right-style: solid;
    border-bottom-style: none;
    border-left-style: solid;
    border-color: #000;
  }
  .form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    border-top-style: none;
    border-right-style: solid;
    border-bottom-style: solid;
    border-left-style: solid;
    border-color: rgb(0,0,0);
    border-top:1px solid rgba(0,0,0,0.08);
  }
  .form-signin-heading {
    color: #fff;
    text-align: center;
    text-shadow: 0 2px 2px rgba(0,0,0,0.5);
  }

</style>


  <script src="https://cdn.jsdelivr.net/npm/axios@0.15.0/dist/axios.min.js"></script>

  <script>

 const START_URL = 'http://localhost:9000';
 const API_URL = START_URL + '/api';
 const APP_URL_START = START_URL + '/app'
 const TABLEAU_DE_BORD_URL = APP_URL_START + '/tableau-de-bord'
 const axios = require('axios');

  export default {
     data :function() {
      return {
        quote: '',
        linkTableauDeBord:'',
        cLogin:'',
        cPassword:'',
        messageErreurAuth:'',
        enErreurAuth:false,
        parentMsg:'message from parent'
      }
    },



    created: function () {

    this.linkTableauDeBord = TABLEAU_DE_BORD_URL;
  },

    methods: {
      getQuote() {
        //this.$http
        axios
          .get(API_URL + '/random-quote')
          .then((response) =>{
            var jsonData = response.data;
            var rQuote = jsonData.quote;
            console.log('data.quote:' + rQuote);
            if (rQuote !=null){
              this.quote = rQuote;
            }


          })
          .catch((jsonErr) => {
            console.log('ERROR : jsonData.status:' + jsonErr.status);
            console.log('ERROR : jsonData.message:' + jsonErr.message);
          });
      },

      getRedirectPage1(elt){
        window.location.href = this.linkTableauDeBord;
      },

      validateAuthent: function(){
        var fLogin = this.cLogin;
        var fPassword = this.cPassword;
        console.log("fLogin:" + fLogin );
        console.log("fPassword:" + fPassword);
        //alert("fLogin:(" + fLogin + ") fPassword:(" + fPassword + ")");

        var fData = {"login":fLogin, "password":fPassword};
        //this.$http
        axios
          .post(API_URL + '/validate-authentification', fData)
          .then((response) => {
            console.log("Authentificated");
            this.enErreurAuth=false;
            this.messageErreurAuth='';
            this.getRedirectPage1('1');

          })
          .catch((jsonErr) => {

            this.enErreurAuth=true;
            this.messageErreurAuth="Erreur d'authentification";
            console.log('enErreurAuth:' + this.enErreurAuth);
            console.log('MSG_ERROR:' + jsonErr);
          });
      }
    }

  }
  </script>
