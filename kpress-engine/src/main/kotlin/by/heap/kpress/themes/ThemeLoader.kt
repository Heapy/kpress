package by.heap.kpress.themes

import by.heap.kpress.api.Theme
import by.heap.kpress.loader.Loader

/**
 * Load all available themes.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface ThemeLoader {
    /**
     * Return map which contains name of theme and [Theme] itself.
     */
    fun load(): Map<String, Theme>
}

class ClassPathThemeLoader(
    private val loader: Loader
) : ThemeLoader {
    private val themes by lazy {
        loader.load(Theme::class)
            .associate { it.name to it }
    }

    override fun load() = themes
}
