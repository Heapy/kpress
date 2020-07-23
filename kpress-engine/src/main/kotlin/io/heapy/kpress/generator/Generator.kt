package io.heapy.kpress.generator

import io.heapy.kpress.extensions.logger
import io.heapy.kpress.fs.FileService
import io.heapy.kpress.generator.markup.MarkupEngine
import io.heapy.kpress.model.Model
import io.heapy.kpress.model.Settings
import io.heapy.kpress.state.FsObject
import io.heapy.kpress.state.FsState
import io.heapy.kpress.state.VirtualFS

class Generator(
    private val asciiDocEngine: MarkupEngine,
    private val fileService: FileService,
    private val settings: Settings,
    private val model: Model
) {


    val logger = logger<Generator>()

    /**
     * Pages generation of that should be initiated manually.
     */
    private val STATIC_PAGES = setOf(
        "home",
        "index",
        "404",
        "search"
    )

    /**
     * Open questions
     * 1. How to localize post/page?
     * @param event
     */
    data class Post<M>(
        val url: String,
        val resources: List<FsObject>,
        val translations: List<Post<M>>,

        val language: String,
        val isDraft: Boolean,
        val metadata: M
    )

    fun generate(state: FsState): VirtualFS {



        /**
         * Generate:
         * posts
         * pages
         * arhive
         * index
         * tags
         * rss
         * sitemap

         */

        return VirtualFS()
    }
}
