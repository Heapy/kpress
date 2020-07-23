package io.heapy.kpress.filters

import io.heapy.kpress.api.Filter

/**
 * @author Ruslan Ibragimov
 */
class TitleFilter : Filter<String> {
    override fun tag(): String = "kp_title"

    override fun filter(data: String): String {
        return "$data : Kpress"
    }
}
