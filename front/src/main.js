import Vue from 'vue';

import App from './components/App.vue';
import Auth from './components/Auth.vue';
import mchild from './components/MChild.vue';
import tableauDeBord from './components/TableauDeBord.vue';

import axios from 'axios';
//import VueResource from 'vue-resource';
//import VueLoader from 'vue-loader';
//Vue.use(VueResource); to define vueResource instead of axios
//Vue.use(VueLoader);

//var app1 = new Vue(App);
//app1.$mount('#hello');

Vue.component('child', mchild);

var AuthComponents = {'child': mchild};

var auth = new Vue(Auth, AuthComponents);
auth.$mount('#app1');


var vTableauDeBord = new Vue(tableauDeBord);
vTableauDeBord.$mount('#tableauDeBord');


import '../sass/style.scss';