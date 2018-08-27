<template>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

<a class="navbar-brand" href="#">Menu</a>
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
  <span class="navbar-toggler-icon"></span>
</button>

<div class="collapse navbar-collapse" id="navbarSupportedContent">
  <ul class="navbar-nav mr-auto">
    <li class="nav-item active">
      <a class="nav-link" href="#">Entreprise</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Salariés</a>
    </li>
    <li class="nav-item-dropdown">
      <a class="nav-link dropdown-toggle"  href="#1" id="navbarDeclaration" role="button" data-toggle="dropdown1"   >
        Déclarations
      </a>
      <div class="dropdown-menu" aria-labelledby="navbarDeclaration">
        <a class="dropdown-item" href="#1">Action</a>
        <a class="dropdown-item" href="#2">Another action</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#3">Something else here</a>
      </div>
    </li>

  </ul>
  <form class="form-inline my-2 my-lg-0">
    <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
  <div class="dropdown">
    <a class="nav-link dropdown-toggle" href="#" id="navbarAccount" role="button" data-toggle="dropdown2" aria-haspopup="true" aria-expanded="false">
      {{login}}
    </a>
    <div class="dropdown-menu" aria-labelledby="navbarAccount">
      <a class="dropdown-item" href="#">Action</a>
      <a class="dropdown-item" href="#">Another action</a>
      <div class="dropdown-divider"></div>
      <a class="dropdown-item" href="#">Something else here</a>
    </div>
  </div>
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
