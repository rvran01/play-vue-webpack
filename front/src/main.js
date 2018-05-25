import Vue from 'vue';

import App from './components/App.vue';
import Auth from './components/Auth.vue';
import mchild from './components/MChild.vue';
import navbar from './components/NavBar.vue';
import tableauDeBord from './components/TableauDeBord.vue';

import axios from 'axios';


Vue.component('child', mchild);
Vue.component('barrenavigation', navbar);

var AuthComponents = {'child': mchild};
var auth = new Vue(Auth, AuthComponents);
auth.$mount('#app1');

var TableauDeBordComponents = {'barrenavigation': navbar};
var vTableauDeBord = new Vue(tableauDeBord, TableauDeBordComponents);
vTableauDeBord.$mount('#tableauDeBord');


import '../sass/style.scss';