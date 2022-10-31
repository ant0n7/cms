<template>
  <div>
    <nav class="navbar navbar-expand-lg">
      <div class="container-fluid">
        <NuxtLink class="navbar-brand" to="/">
          <!-- <nuxt-img src="/icon.png" alt="logo" /> -->
          <p id="detken-text-nav">DetkenCMS</p>
        </NuxtLink>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNavDropdown"
          aria-controls="navbarNavDropdown"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <!-- <div id="navbarNavDropdown" class="collapse navbar-collapse"> -->
        <div id="navbarNavDropdown" class="collapse navbar-collapse">
          <ul class="navbar-nav me-auto">
            <li class="nav-item">
              <NuxtLink class="nav-link" to="/employees">Employees</NuxtLink>
            </li>
            <li class="nav-item">
              <NuxtLink class="nav-link disabled" to="#">Posts</NuxtLink>
            </li>
          </ul>
          <ul class="navbar-nav">
            <li class="nav-item dropdown fe">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                >Account</a
              >
              <ul class="dropdown-menu">
                <li>
                  <NuxtLink class="dropdown-item" to="#">Settings</NuxtLink>
                </li>
                <li>
                  <NuxtLink class="dropdown-item" to="#">Users</NuxtLink>
                </li>
                <li>
                  <a
                    class="dropdown-item link-external"
                    href="https://www.detkendesign.com"
                    target="_blank"
                    >Your Website</a
                  >
                </li>
                <li>
                  <button
                    class="dropdown-item"
                    style="color: red"
                    @click="logoutUser"
                  >
                    Logout
                  </button>
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  methods: {
    async logoutUser() {
      await this.$auth.logout()
    },
  },
}
</script>
