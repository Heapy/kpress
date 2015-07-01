package by.heap.kpress.filters

import by.heap.kpress.api.Filter

/**
 * @author Ruslan Ibragimov
 */
class TitleFilter : Filter<String> {
    override fun tag(): String = "kp_title"

    override fun filter(data: String): String {
        return "$data : Kpress"
    }
}
