package by.heap.kpress.plugins

import by.heap.kpress.api.Plugin
import by.heap.kpress.loader.Loader

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
