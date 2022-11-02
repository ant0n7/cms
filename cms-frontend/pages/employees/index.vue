<template>
  <div>
    <h1>Employees</h1>
    <p>This section is for display purposes only.</p>

    <client-only>
      <div v-if="employees.length > 0" class="row">
        <div
          v-for="employee in employees"
          :key="employee.id"
          class="col-md-4 col-12"
        >
          <BasicCard
            class="mb-4"
            :title="`${employee.firstname} ${employee.lastname}`"
            :subtitle="employee.jobTitle"
            :img-src="
              'data:image/jpg;base64,' +
              getEmployeeImage(employee).then((res) => res.toString('base64'))
            "
          >
            <p class="card-text">{{ employee.email }}</p>
          </BasicCard>
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
import { response } from 'express'
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
  // name: 'EmployeesPage',
  data: () => ({
    employees: new Array<Employee>(),
  }),
  async fetch() {
    this.employees = await this.$axios.$get('/data/employees/')
    // this.employees.forEach(async (employee: Employee) => {
    //   await this.$axios
    //     .$get(`/data/employees/${employee.id}/image`)
    //     .then((response) => {
    //       const imageEncoded = Buffer.from(response, 'base64')
    //       ;(<HTMLImageElement>(
    //         document!.getElementById(employee.id + '_image')
    //       ))!.src = `data:image/jpg;base64,${imageEncoded}`
    //     })
    // })
  },
  methods: {
    async getEmployeeImage(employee: Employee): Promise<Buffer> {
      // await this.$axios
      //   .$get(`/data/employees/${employee.id}/image`)
      //   .then((response: string) => {
      //     const imageEncoded = Buffer.from(response, 'base64')
      //     ;(<HTMLImageElement>(
      //       document!.getElementById(employee.id + '_image')
      //     ))!.src = `data:image/jpg;base64,${imageEncoded}`
      //   })
      const response = await this.$axios.$get(
        `/data/employees/${employee.id}/image`
      )

      return Buffer.from(response)
    },
    base64Encode(s: string) {
      return Buffer.from(s).toString('base64')
    },
  },
})
</script>
