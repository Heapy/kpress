package io.heapy.kpress.application

import io.heapy.kpress.theme.api.Theme

/**
 * Load all available themes.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
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
