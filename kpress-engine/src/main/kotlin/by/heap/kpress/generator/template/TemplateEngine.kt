package by.heap.kpress.generator.template

/**
 * Interface that all template engines used in kpress should follow.
 *
 * @author Ruslan Ibragimov
 */
interface TemplateEngine {

    /**
     * Render particular page using provided data and template.
     *
     * @param template path in classpath to template with theme prefix. example: kfifteen/404.jade
     * @param model object that used to fill template
     * @return fully rendered page
     */
    fun render(template: String, model: MutableMap<String, Any>): String
}
