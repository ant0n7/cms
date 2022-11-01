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
            <p class="card-text">{{ employee.jobTitle }}</p>
            <p class="card-text">{{ employee.email }}</p>
          </div>
        </div>
      </div>
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
  },
})
</script>
