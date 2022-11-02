<template>
  <div>
    <h1>Employees</h1>
    <p>This section is for display purposes only.</p>

    <div v-if="employees.length > 0" class="row">
      <div
        v-for="employee in employees"
        :key="employee"
        class="col-md-4 col-12"
      >
        <div class="card w-100">
          <div class="card-body">
            <h5 class="card-title">
              {{ employee.firstname }} {{ employee.lastname }}
            </h5>
            <!-- Card image -->
            <img
              :id="employee.id + '_image'"
              class="card-img-top"
              src=""
              alt="Card image cap"
            />
            <p class="card-text">{{ employee.jobTitle }}</p>
            <p class="card-text">{{ employee.email }}</p>
          </div>
        </div>
      </div>
    </div>
    <div v-else-if="employees.length == 0">
      <div class="alert alert-warning" role="alert">No employees found.</div>
    </div>
    <div v-else>
      <div class="alert alert-error" role="alert">Couldn't load employees.</div>
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'
// import Employee from '~/assets/types/employee'

export default Vue.extend({
  // name: 'EmployeesPage',
  data: () => ({
    employees: [],
  }),
  async fetch() {
    this.employees = await this.$axios.$get('/data/employees/')
    this.employees.forEach(async (employee) => {
      await this.$axios
        .$get(`/data/employees/${employee.id}/image`)
        .then((response) => {
          const imageEncoded = btoa(response)
          ;(<HTMLImageElement>(
            document!.getElementById(employee.id + '_image')
          ))!.src = `data:image/jpg;base64,${imageEncoded}`
        })
    })
  },
})
</script>
