<template>
  <div>
    <form @submit.prevent="userLogin">
      <div>
        <label>Username</label>
        <input v-model="login.username" type="text" />
      </div>
      <div>
        <label>Password</label>
        <input v-model="login.password" type="text" />
      </div>
      <div>
        <button type="submit">Login</button>
      </div>
    </form>
    <button @click="logUser()">Log User Info</button>
  </div>
</template>

<script>
export default {
  layout: 'blank',
  data() {
    return {
      login: {
        username: '',
        password: '',
      },
    }
  },
  methods: {
    async loginUser(loginInfo) {
      await this.$auth.loginWith('local', {
        data: loginInfo,
      })
    },
    logUser() {
      console.log(this.$auth.loggedIn)
      console.log(JSON.stringify(this.$auth.user))
    },
  },
}
</script>
