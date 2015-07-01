package by.heap.kpress.model.functions

/**
 * Base Helper Interface
 *
 * @author Ruslan Ibragimov
 */
interface Function {

    /**
     * @return Name of the helper that will be used in template
     */
    val name: String
}

/**
 * Converts input to specified language
 *
 * @author Ruslan Ibragimov
 */
class InternationalizationFunction : Function {
    override val name = "i18n"

    /**
     * Returns localized string using input English string.
     *
     * @param string english string to localize.
     * @return localized string.
     */
    fun t(string: String): String {
        // TODO: Implement logic with po and mo files using GNU gettext
        return "!!!" + string
    }
}
