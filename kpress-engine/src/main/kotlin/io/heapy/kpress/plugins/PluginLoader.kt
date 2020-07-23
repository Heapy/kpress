package io.heapy.kpress.plugins

import io.heapy.kpress.plugin.api.Plugin
import io.heapy.kpress.loader.Loader

/**
 * Load all available plugins.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface PluginLoader {
    /**
     * Return map which contains namespace of plugin and [Plugin] itself.
     */
    fun load(): Map<String, Plugin>
}

class ClassPathPluginLoader(
    private val loader: Loader
) : PluginLoader {
    private val plugins by lazy {
        loader.load(Plugin::class)
            .associate { it.namespace to it }
    }

    override fun load() = plugins
}
