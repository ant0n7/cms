<template>
  <div>
    <div class="row">
      <div
        class="col-12 d-flex flex-row justify-content-between align-items-center"
      >
        <h1 class="">Employee</h1>
        <NuxtLink :to="`${$route.fullPath}/edit`" class="btn btn-primary"
          >Edit</NuxtLink
        >
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <div v-if="employee.id">
          <div>
            <img :src="`data:image/jpg;base64,${employeeImage}`" />
          </div>
          <div>
            <h2>{{ employee.firstname }} {{ employee.lastname }}</h2>
            <p>Email: {{ employee.email }}</p>
            <p>Job Title: {{ employee.jobTitle }}</p>
            <p>Gender: {{ employee.gender }}</p>
            <p>Gender: {{ employee.description }}</p>
          </div>
        </div>
        <div v-else>
          <div class="alert alert-error" role="alert">
            Couldn't load employee.
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
// import { Buffer } from 'buffer'
import Vue from 'vue'

class Employee {
  id?: string
  firstname?: string
  lastname?: string
  gender?: string
  email?: string
  jobTitle?: string
  description?: string
}

export default Vue.extend({
  // name: 'EmployeePage',
  data: () => ({
    employee: new Employee(),
    employeeImage: '',
  }),
  async fetch() {
    this.employee = await this.$axios.$get(
      `/data/employees/${this.$route.params.id}`
    )
    // await this.$axios
    //   .$get(`/data/employees/${this.$route.params.id}/image`)
    //   .then((response: string) => {
    //     this.employeeImage = Buffer.from(response).toString('base64')
    //   })
  },
})
</script>
