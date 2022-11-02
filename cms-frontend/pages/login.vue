<template>
  <div>
    <h1 class="mt-5">DetkenCMS</h1>
    <div class="container-fluid">
      <div class="row mt-4">
        <div class="col-md-4"></div>
        <div class="col-md-4">
          <form @submit.prevent="loginUser(login)">
            <div>
              <label for="username-input" class="">Username</label>
              <input
                id="username-input"
                v-model="login.username"
                class="form-control"
                type="username"
              />
            </div>
            <div class="mt-2">
              <label for="password-input">Password</label>
              <input
                id="password-input"
                v-model="login.password"
                class="form-control"
                type="password"
              />
            </div>
            <div class="mt-4">
              <button class="btn btn-primary w-100" type="submit">Login</button>
            </div>
          </form>
        </div>
        <div class="col-md-4"></div>
      </div>
    </div>
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
  },
}
</script>

<style scoped>
h1 {
  text-align: center;
}
</style>
