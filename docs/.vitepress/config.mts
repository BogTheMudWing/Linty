import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  title: "Linty",
  description: "Spigot freeform player claiming system",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
      { text: 'Home', link: '/' },
      { text: 'Learn', link: '/learn' }
    ],

    sidebar: [
      {
        text: 'Introduction',
        items: [
          { text: 'Learn', link: '/learn' },
          { text: 'Getting Started', link: '/start' }
        ]
      }
    ],

    socialLinks: [
      { icon: 'github', link: 'https://github.com/BogTheMudWing/Linty' }
    ],

    search: {
      provider: 'local'
    },

    footer: {
      message: 'Released under the MIT License.',
      copyright: 'Copyright © 2025 BogTheMudWing'
    }
  },
  locales: {
    root: {
      label: 'English',
      lang: 'en'
    }
  }
})
