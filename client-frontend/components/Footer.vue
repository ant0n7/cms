<template>
  <footer>
      <span>
          &#169; {{ year }} Detken Design | contact&#64;detkendesign.com | <NuxtLink to="/impressum" no-prefetch>Impressum</NuxtLink>
      </span>
  </footer>
</template>

<script>
export default {
  data() {
      return {
          year: new Date().getFullYear()
      }
  }
}
</script>