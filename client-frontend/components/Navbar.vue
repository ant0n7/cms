<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <NuxtLink class="navbar-brand" to="/">
        <p id="detken-text-nav">Detken Design</p>
        <img id="nav-logo" src="/logo_d_white.png" alt="Logo" />
      </NuxtLink>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavAltMarkup"
        aria-controls="navbarNavAltMarkup"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse navbar-text" id="navbarNavAltMarkup">
        <div class="navbar-nav ms-auto">
          <NuxtLink
            class="nav-link" to="/">
            Home
          </NuxtLink>
          <NuxtLink
            class="nav-link" to="/ueber-uns">
            &Uuml;ber uns
          </NuxtLink>
          <NuxtLink class="nav-link" to="/projekte">Projekte</NuxtLink>
        </div>
      </div>
    </div>
  </nav>
</template>