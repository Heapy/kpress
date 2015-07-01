package by.heap.kpress.generator.template

import freemarker.cache.ClassTemplateLoader
import freemarker.template.Configuration
import freemarker.template.TemplateException
import java.io.IOException
import java.io.StringWriter

/**
 * Used to convert "*.ftl" templates.
 *
 * @author Ruslan Ibragimov
 */
class FreemarkerEngine : TemplateEngine {
    private val configuration: Configuration = Configuration(Configuration.getVersion())

    init {
        configuration.templateLoader = ClassTemplateLoader(javaClass, "/")
    }

    override fun render(template: String, model: MutableMap<String, Any>): String {
        try {
            val freemarkerTemplate = configuration.getTemplate(template)
            val writer = StringWriter()

            val function = { string: String -> string }

            model["helper"] = function

            freemarkerTemplate.process(model, writer)
            return writer.toString()
        } catch (e: IOException) {
            throw RuntimeException(e)
        } catch (e: TemplateException) {
            throw RuntimeException(e)
        }
    }
}
