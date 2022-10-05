<template>
  <div>
    <a
      :to="projectLink"
      :title="projectTitle"
      target="_blank"
      rel="noopener"
    >
      <img class="desktop" :src="'/projects/' + projectImage + '-desktop.jpg'" :alt="projectAlt" />
      <img class="mobile" :src="'/projects/' + projectImage + '-mobile.jpg'" :alt="projectAlt" />
    </a>
    <h3 class="img-desc">{{ projectTitle }}</h3>
  </div>
</template>

<script lang="ts">
export default {
  props: {
    projectTitle: String,
    projectAlt: String,
    projectLink: String,
    projectImage: String, // name of the image file without extension and path
  }
}
</script>