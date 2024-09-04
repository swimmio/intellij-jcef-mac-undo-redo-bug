<script setup lang="ts">
import TiptapEditor from '@/components/TiptapEditor.vue'
</script>

<template>
  <main>
    <TiptapEditor />
  </main>
</template>

<style scoped>
:global(body) {
  margin: 0;
}

main {
  background-color: white;
  height: 100vh;
  overflow: auto;
}
</style>
