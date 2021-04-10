package io.heapy.kpress.plugins.search

import io.heapy.kpress.plugin.api.Plugin
import java.util.EventListener

/**
 * Search plugin
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
class SearchPlugin : Plugin {

    override val namespace: String = "search"

    override fun addEventListener(listener: EventListener) {

    }
}
