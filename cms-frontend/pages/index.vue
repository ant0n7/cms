<template>
  <div>
    <h1 v-if="!getLoggedInName()">Welcome</h1>
    <h1 v-else>Welcome, {{ getLoggedInName() }}!</h1>

    <div class="card w-100" style="height: 70vh">
      <div class="card-body">
        <h5 class="card-title">Your Website</h5>
        <iframe
          src="http://localhost:3000/"
          class="w-100"
          frameborder="0"
        ></iframe>
      </div>
    </div>

    <h2 class="section-heading">Manage Content</h2>
    <div class="row">
      <div class="col-md-4 col-12">
        <div class="card w-100">
          <div class="card-body">
            <h5 class="card-title">Employees</h5>
            <NuxtLink class="btn btn-primary" to="/employees">Manage</NuxtLink>
          </div>
        </div>
      </div>
      <div class="col-md-4 col-12">
        <div class="card w-100">
          <div class="card-body">
            <h5 class="card-title">News</h5>
            <p class="card-text">This feature is currently unavailable</p>
            <!-- <NuxtLink class="btn disabled" to="/employees">Manage</NuxtLink> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'IndexPage',
  data() {
    return {}
  },
  methods: {
    logUser() {
      console.log(this.$auth.loggedIn)
      console.log(JSON.stringify(this.$auth.user))
    },
    getLoggedInName() {
      return this.$auth.user!.firstname
    },
  },
})
</script>

<style lang="scss" scoped>
iframe {
  height: 90%;
  border-radius: 5px;

  body::-webkit-scrollbar {
    display: none;
  }

  -ms-overflow-style: none;
  scrollbar-width: none;
}
</style>
