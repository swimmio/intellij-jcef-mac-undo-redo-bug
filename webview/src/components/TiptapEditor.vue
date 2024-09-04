<script setup lang="ts">
import { useEditor, EditorContent, Extension } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'

const editor = useEditor({
  content: '<p>I’m running Tiptap with Vue.js. 🎉</p>',
  extensions: [
    StarterKit,
    Extension.create({
      name: 'keyboardShortcuts',

      addKeyboardShortcuts() {
        return {
          'Mod-z': () => {
            console.log('Mod-z pressed')
            return false
          },

          'Mod-Shift-Z': () => {
            console.log('Mod-Shift-Z pressed')
            return false
          },

          'Mod-d': () => {
            console.log('Mod-d pressed')
            return false
          }
        }
      }
    })
  ]
})
</script>

<template>
  <EditorContent :editor="editor" />
</template>
