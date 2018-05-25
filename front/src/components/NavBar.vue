<template>
               <nav class="navbar">

                   <div class="navbar-header">

                     <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                      </button>
                      <a class="navbar-brand brand-primary" href="#">PAIE {{login}}</a>
                    </div>
                   <div class="collapse navbar-collapse" id="navbarSupportedContent">
                       <ul class="nav navbar-nav">
                           <li class="nav-item active">
                               <a class="nav-link" href="">Déclaration</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link" href="">Entreprise</a>
                           </li>
                           <li class="nav-item">
                               <a class="nav-link" href="">Salariés</a>
                           </li>
                           <li class="nav-item dropdown">
                               <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Specificités</a>
                               <div class="dropdown-menu dropdown-green" aria-labelledby="navbarDropdownMenuLink">
                                   <a class="dropdown-item" href="#">Bilan</a>
                                   <a class="dropdown-item" href="#">Statistiques</a>
                               </div>
                           </li>
                       </ul>

                   </div>

               </nav>
  </template>


<script>
  module.exports = {

    props: ['login'],
    data: function(){
        return {
        }
    }
  }
</script>
