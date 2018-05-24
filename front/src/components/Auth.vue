<template>
    <div class="col-sm-6 col-sm-offset-3" id="example-1">
      <h1>Sample</h1>
      <a class="btn btn-primary" v-on:click="getQuote()">Check</a>
      <div class="quote-area" v-if="quote">
        <h2><blockquote>{{ quote }}</blockquote></h2>
      </div>

      <!--a v-on:click="getRedirectPage1('1')">Redirection</a-->
      <a v-bind:href="linkToGoogle">Redirection</a>
      <br/>
        <form>
          <input type="text" v-model="cLogin" placeholder="LOGIN"/>
          <input type="password" v-model="cPassword" placeholder="PASSWORD"/>
          <button type="button" class="btn btn-primary" v-on:click.prevent="validateAuthent">Valider</button>
          <br/>

          <div class="container">
            <span v-show="enErreurAuth" class="badge badge-danger">{{messageErreurAuth}}</span>
          </div>

        </form>

        <child v-bind:mymessage="parentMsg"></child>

    </div>

</template>

  <script src="https://cdn.jsdelivr.net/npm/axios@0.15.0/dist/axios.min.js"></script>

  <script>


 const API_URL = 'http://localhost:9000/api';
 const axios = require('axios');

  export default {
     data :function() {
      return {
        quote: '',
        linkToGoogle:'',
        cLogin:'',
        cPassword:'',
        messageErreurAuth:'',
        enErreurAuth:false,
        parentMsg:'message from parent'
      }
    },



    created: function () {

    this.linkToGoogle = 'http://www.google.com';
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
        window.location.href = 'http://www.yahoo.com';
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
