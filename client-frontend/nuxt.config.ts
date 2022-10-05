// https://v3.nuxtjs.org/api/configuration/nuxt.config
export default defineNuxtConfig({
  css: [
    "~/assets/scss/futura.css",
    "~/assets/scss/main.scss", // maybe replace ~ with @
    "~/assets/scss/about.scss",
    "~/assets/scss/navbar.scss",
    "~/assets/scss/footer.scss",
    "~/assets/scss/home.scss",
    "~/assets/scss/gallery.scss",
  ],

  app: {
    head: {
      title: "Detken Design - Webdesign für Anwaltskanzleien",
      meta: [
        { charset: "utf-8" },
        { name: "viewport", content: "width=device-width, initial-scale=1" },
        {
          hid: "description",
          name: "description",
          content:
            "Wir helfen Anwaltskanzleien dabei, ihre Mandantengewinnung durch eine moderne Webseite zu verbessern. Mit unseren durchdachten Techniken verhindern wir, dass potenzielle Mandanten und Mitarbeiter zum Konkurrenten abspringen und hilft beim Vertrauensaufbau von Interessenten. aus Zürich spezialisiert auf Anwaltskanzleien.",
        },
        {
          name: "keywords",
          content:
            "Detken Design, Webdesign, Anwalt, Anwaltskanzlei, Webdesign für Anwaltskanzleien, Website, Webdesign Zürich, Webdesign Agentur",
        },
        { name: "author", content: "Detken Design" },
        { name: "robots", content: "noindex" },
        { name: "revisit-after", content: "1 days" },
        { name: "language", content: "de-DE" },
        {
          name: "og:title",
          content: "Detken Design - Webdesign für Anwaltskanzleien",
        },
        {
          name: "og:description",
          content:
            "Wir helfen Anwaltskanzleien dabei, ihre Mandantengewinnung durch eine moderne Webseite zu verbessern. Mit unseren durchdachten Techniken verhindern wir, dass potenzielle Mandanten und Mitarbeiter zum Konkurrenten abspringen und hilft beim Vertrauensaufbau von Interessenten. aus Zürich spezialisiert auf Anwaltskanzleien.",
        },
        { name: "og:type", content: "website" },
        { name: "og:url", content: "https://www.detkendesign.com" },
        { name: "og:image", content: "https://detkendesign.com/logo.png" },
        { name: "og:image:width", content: "1200" },
        { name: "og:image:height", content: "630" },
        { name: "og:image:alt", content: "Detken Design" },
      ],
      // link: [{ rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' }],
      // Bootstrap JS bundle
      // script: [
      //   {
      //     src: 'https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js',
      //     body: true,
      //   },
      // ]
    },
  },
});
