<template>
  <div>
    <div class="row">
      <div
        class="col-12 d-flex flex-row justify-content-between align-items-center"
      >
        <h1 class="">Employee</h1>
        <NuxtLink :to="`/employees/undefined/edit`" class="btn btn-primary"
          >Add</NuxtLink
        >
      </div>
    </div>

    <client-only>
      <div v-if="employees.length > 0" class="row">
        <div
          v-for="employee in employees"
          :key="employee.id"
          class="col-md-4 col-12"
        >
          <NuxtLink class="link-unstyled" :to="`/employees/${employee.id}`">
            <BasicCard
              class="mb-4"
              :title="`${employee.firstname} ${employee.lastname}`"
              :subtitle="employee.jobTitle"
            >
              <p class="card-text">{{ employee.email }}</p>
            </BasicCard>
          </NuxtLink>
        </div>
      </div>
      <div v-else-if="employees.length == 0">
        <div class="alert alert-warning" role="alert">No employees found.</div>
      </div>
      <div v-else>
        <div class="alert alert-error" role="alert">
          Couldn't load employees.
        </div>
      </div>
    </client-only>
  </div>
</template>

<script lang="ts">
import { Buffer } from 'buffer'
import Vue from 'vue'
// import Employee from assets/types
// import Employee from '~/types'

class Employee {
  id?: string
  firstname?: string
  lastname?: string
  email?: string
  jobTitle?: string
}

export default Vue.extend({
  data: () => ({
    employees: new Array<Employee>(),
  }),
  async fetch() {
    this.employees = await this.$axios.$get('/data/employees/')
  },
  methods: {
    // async getEmployeeImage(employee: Employee): Promise<string> {
    // await this.$axios
    //   .$get(`/data/employees/${employee.id}/image`)
    //   .then((response: string) => {
    //     const imageEncoded = Buffer.from(response, 'base64')
    //     ;(<HTMLImageElement>(
    //       document!.getElementById(employee.id + '_image')
    //     ))!.src = `data:image/jpg;base64,${imageEncoded}`
    //   })
    // const response: Promise<string> =
    // let encoded = ''

    // await this.$axios
    //   .$get(`/data/employees/${employee.id}/image`)
    //   .then((response: string) => {
    //     encoded = Buffer.from(response).toString('base64')
    //   })

    // return encoded
    // },
    base64Encode(s: string) {
      return Buffer.from(s).toString('base64')
    },
  },
})
</script>
