<template>
  <div class="container-fluid">
    <div class="row centered-parent">
      <div class="col-12">
        <h1 class="centered">
          <slot />       
        </h1>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    content: String
  }
}
</script>