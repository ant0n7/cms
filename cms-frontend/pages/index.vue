<template>
  <div>
    <h1>Index</h1>
    <button @click="logUser">Log user</button>
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
