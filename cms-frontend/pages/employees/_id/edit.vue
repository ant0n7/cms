<template>
  <div>
    <div class="row">
      <div
        class="col-12 d-flex flex-row justify-content-between align-items-center"
      >
        <h1>Employee Editor</h1>
        <NuxtLink :to="`/employees/${employee.id}`" class="btn btn-secondary"
          >Cancel</NuxtLink
        >
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <form @submit.prevent="submitForm()">
          <div class="mb-2">
            <label for="firstname-input" class="form-label mb-0"
              >First Name</label
            >
            <input
              id="firstname-input"
              v-model="employee.firstname"
              class="form-control"
              type="text"
              required
            />
          </div>
          <div class="mb-2">
            <label for="lastname-input" class="form-label mb-0"
              >Last Name</label
            >
            <input
              id="lastname-input"
              v-model="employee.lastname"
              class="form-control"
              type="text"
              required
            />
          </div>
          <div class="mb-2">
            <label for="email-input" class="form-label mb-0"
              >Public Email</label
            >
            <input
              id="email-input"
              v-model="employee.email"
              class="form-control"
              type="email"
              required
            />
          </div>
          <div class="mb-2">
            <label for="gender-input" class="form-label mb-0">Gender</label>
            <select
              id="gender-input"
              v-model="employee.gender"
              class="dropdown form-select"
              type="select"
            >
              <option value="MALE">Male</option>
              <option value="FEMALE">Female</option>
              <option value="OTHER">Other</option>
            </select>
          </div>

          <div class="d-flex flex-row justify-content-start align-items-center">
            <button type="submit" class="btn btn-success m-1 ms-0">Save</button>
            <NuxtLink
              :to="`/employees/${employee.id}`"
              class="btn btn-secondary m-1"
              >Cancel</NuxtLink
            >
            <button class="btn btn-danger m-1" @click="deleteEmployee()">
              Delete
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { data } from 'browserslist'
import Vue from 'vue'

class Employee {
  id?: string
  firstname?: string
  lastname?: string
  gender?: string
  email?: string
  jobTitle?: string
}

export default Vue.extend({
  data: () => ({
    employee: new Employee(),
  }),
  async fetch() {
    this.employee = await this.$axios.$get(
      `/data/employees/${this.$route.params.id}`
    )
  },
  methods: {
    async submitForm() {
      if (!this.employee.id) {
        await this.saveNewEmployee()
      } else {
        await this.saveExistingEmployee()
      }
    },
    async saveNewEmployee() {
      const newEmployee = await this.$axios.$post(
        `/data/employees/`,
        this.employee
      )
      this.$router.push(`/employees/${newEmployee.id}`)
    },
    async deleteEmployee() {
      await this.$axios.$delete(`/data/employees/${this.employee.id}`)
      this.$router.push(`/employees`)
    },
    async saveExistingEmployee() {
      await this.$axios.$put(
        `/data/employees/${this.employee.id}`,
        this.employee
      )
      this.$router.push(`/employees/${this.employee.id}`)
    },
  },
})
</script>
