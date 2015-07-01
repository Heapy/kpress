package by.heap.kpress.filters

import by.heap.kpress.api.Filter

/**
 * @author Ruslan Ibragimov
 */
class FooterFilter : Filter<String> {
    override fun tag(): String = "kp_footer"

    override fun filter(type: String): String {
        return """
        $type
        <script>alert(1)</script>
        """
    }
}
