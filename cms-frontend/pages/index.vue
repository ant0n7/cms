<template>
  <div>
    <h1>Welcome</h1>

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
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'IndexPage',
  methods: {
    logUser() {
      console.log(this.$auth.loggedIn)
      console.log(JSON.stringify(this.$auth.user))
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
