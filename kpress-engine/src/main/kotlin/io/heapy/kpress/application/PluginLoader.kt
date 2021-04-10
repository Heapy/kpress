package io.heapy.kpress.application

import io.heapy.kpress.plugin.api.Plugin

/**
 * Load all available plugins.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
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
            .associateBy { it.namespace }
    }

    override fun load() = plugins
}
