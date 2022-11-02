<script setup>
const { data: employees } = await useFetch("/data/employees");
</script>

<template>
  <div>
    <PageTitle>&Uuml;ber uns</PageTitle>

    <main>
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-3"></div>
          <div class="col-md-6 col-12">
            <p>
              Wir planen und realisieren Webdesign für Anwaltskanzleien. Dabei
              setzen wir durchdachte Techniken ein, die potenzielle Kunden und
              Mitarbeiter überzeugen. Dadurch verhindern wir unter anderem, dass
              Ihre Website-Besucher zu Ihren Konkurrenten abspringen.
            </p>
            <i class="fa fa-quote-left" aria-hidden="true"></i>
          </div>
          <div class="col-md-3"></div>
        </div>
        <div class="team">
          <div v-for="employee in employees" :key="employee.id">
            <div class="row team-title-row">
              <div class="col-md-3"></div>
              <div class="col-md-6 col-12">
                <h2 class="team-title">
                  {{ employee.firstname }} {{ employee.lastname }}
                </h2>
              </div>
              <div class="col-md-3"></div>
            </div>
            <div class="row team-desc-row">
              <div class="col-md-3"></div>
              <div class="col-md-2 col-12">
                <p class="team-job" style="opacity: 50%">
                  {{ employee.jobTitle }}
                </p>
              </div>
              <div class="col-md-4 col-12">
                <p class="team-desc">
                  {{ employee.description }}
                  <br />
                  <br />
                  <a :href="'mailto:' + employee.email">{{ employee.email }}</a>
                </p>
              </div>
              <div class="col-md-3"></div>
            </div>
          </div>
          <!-- <div class="row team-title-row">
            <div class="col-md-3"></div>
            <div class="col-md-6 col-12">
              <h2 class="team-title">Anton Detken</h2>
            </div>
            <div class="col-md-3"></div>
          </div>
          <div class="row team-desc-row">
            <div class="col-md-3"></div>
            <div class="col-md-2 col-12">
              <img class="team-img" src="/team/detken_anton_portrait.jpg" />
              <p class="team-job" style="opacity: 50%">
                Gesch&auml;ftsf&uuml;hrer
              </p>
            </div>
            <div class="col-md-4 col-12">
              <p class="team-desc">
                Anton Detken machte eine Ausbildung zum Informatiker bei Google
                und entdeckte dabei seine Leidenschaft f&uuml;r Design. Seit
                2020 bildet er sich stets weiter, um bestmögliche Ergebnisse
                f&uuml;r seine Kunden zu erreichen. Dabei hat er sich auf die
                Entwicklung von Websites für Anwaltskanzleien spezialisiert.
                <br />
                <br />
                <a href="mailto:anton@detkendesign.com"
                  >anton@detkendesign.com</a
                >
              </p>
            </div>
            <div class="col-md-3"></div>
          </div> -->
        </div>
      </div>
    </main>
  </div>
</template>

<script>
export default {
  head: {
    title: "Über uns - Detken Design",
    meta: [
      {
        hid: "description",
        name: "description",
        content:
          "Wir planen und realisieren Webdesign für Anwaltskanzleien. Dabei setzen wir durchdachte Techniken ein, die potenzielle Kunden und Mitarbeiter überzeugen. Dadurch verhindern wir unter anderem, dass Ihre Website-Besucher zu Ihren Konkurrenten abspringen.",
      },
      {
        hid: "og:description",
        name: "og:description",
        content:
          "Wir planen und realisieren Webdesign für Anwaltskanzleien. Dabei setzen wir durchdachte Techniken ein, die potenzielle Kunden und Mitarbeiter überzeugen. Dadurch verhindern wir unter anderem, dass Ihre Website-Besucher zu Ihren Konkurrenten abspringen.",
      },
    ],
  },
  data: () => ({
    // employees: new Array<Employee>(),
  }),
  // async fetch() {
  //   this.employees = await this.$axios.$get("/data/employees/");
  // },
};
</script>
