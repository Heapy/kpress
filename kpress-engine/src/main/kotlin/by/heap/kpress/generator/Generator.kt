package by.heap.kpress.generator

import by.heap.kpress.api.Filter
import by.heap.kpress.extensions.logger
import by.heap.kpress.fs.FileService
import by.heap.kpress.generator.markup.AsciiDocEngine
import by.heap.kpress.generator.template.TemplateEngine
import by.heap.kpress.model.Model
import by.heap.kpress.model.Settings
import by.heap.kpress.state.State
import by.heap.kpress.state.VirtualFS

class Generator(
    private val asciiDocEngine: AsciiDocEngine,
    private val kpressFilters: List<Filter<String>>,
    private val freemarkerEngine: TemplateEngine,
    private val fileService: FileService,
    private val settings: Settings,
    private val model: Model
) {


    val logger = logger<Generator>()

    /**
     * Pages generation of that should be initiated manually.
     */
    private val STATIC_PAGES = setOf("home", "index", "404", "search")

    /**
     * Open questions
     * 1. How to localize post/page?


     * @param event
     */
    fun generate(state: State): VirtualFS {

//        fileService.scanFolder(Paths.get(settings.input))?.forEach {
//            println(it.left + " " + it.right.fileName)
//        }
//
//        logger.info(freemarkerEngine.render(settings.template + "/" + "index.ftl", model.model))
//
//        logger.info(asciiDocEngine.convert(File("./blog/assets/index.adoc")).toString())
//
//        logger.info(jadeEngine.render(settings.template + "/" + "404.jade", model.model))

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
