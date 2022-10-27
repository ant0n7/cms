<template>
  <div>
    <h1>Login</h1>
    <p>Username: <input v-model="loginData.username" type="text" /></p>
    <p>Password: <input v-model="loginData.password" type="password" /></p>
    <p>
      <button
        @click="
          userLogin({
            username: loginData.username,
            password: loginData.password,
          })
        "
      >
        Login
      </button>
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginData: {
        username: '',
        password: '',
      },
    }
  },
  methods: {
    userLogin(localLoginData) {
      alert('Login: ' + localLoginData.username + ':' + localLoginData.password)
    },
  },
}
</script>
