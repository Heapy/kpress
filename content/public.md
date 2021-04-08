- /index.html
- /feed.xml
- /page/index.html
- /page/${idx}/index.html

- /${slug}/index.html - page
- /${year}/${month}/${day}/${slug}/index.html - post
- /${alias}/index.html - post alias, redirect

- /categories/${name}/index.html
- /categories/${name}/feed.xml
- /categories/${name}/page/${idx}/index.html

- /tags/${name}/index.html
- /tags/${name}/feed.xml
- /tags/${name}/page/${idx}/index.html

- /sitemap.xml

## post/page:
```yaml
title: Kotlin Coroutines In Practise
date: 1991-12-27
slug: kotlin-coroutines-in-practise (or filename) (or filename with path for pages)
template: Coroutines Post
category: Development
author: IRus - alias
sticky: true/false
tags:
- Kotlin
- Coroutines
aliases:
- some-alias
```
