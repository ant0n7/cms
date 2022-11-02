<template>
  <div class="card w-100">
    <div class="card-body">
      <h5 v-if="title" class="card-title">{{ title }}</h5>
      <h6 v-if="subtitle" class="card-subtitle mb-2 text-muted">
        {{ subtitle }}
      </h6>
      <!-- Card image -->
      <img
        v-if="imgSrc"
        :id="imgId"
        class="card-img-top"
        :src="imgSrc"
        alt="Card image cap"
      />
      <slot />
      <!-- <div v-for="text in texts?.textProps" :key="text?.str">
      <p class="card-text" :class="text?.class">{{ text }}</p>
    </div> -->
    </div>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

// type TextProp = {
//   str: string
//   class: string
// }

// class TextPropArray {
//   textProps?: TextProp[]
// }

export default Vue.extend({
  props: {
    title: {
      type: String,
      required: false,
      default: undefined,
    },
    subtitle: {
      type: String,
      required: false,
      default: undefined,
    },
    imgSrc: {
      type: String,
      required: false,
      default: undefined,
    },
    imgId: {
      type: String,
      required: false,
      default: undefined,
    },
    // texts: {
    //   type: TextPropArray,
    //   required: false,
    //   default: undefined,
    // },
  },
})
</script>
