package io.heapy.kpress.application

import io.heapy.kpress.engine.extensions.logger

/**
 * Prints kpress banner.
 *
 * https://devops.datenkollektiv.de/banner.txt/index.html
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
class BannerStartupListener : StartupListener {
    override suspend fun onStartup() {
        LOGGER.info(banner)
    }

    companion object {
        private val LOGGER = logger<BannerStartupListener>()

        private val banner = """

            ,  , ;-.  ,-.  ,--.  ,-.   ,-.
            | /  |  ) |  ) |    (   ` (   `
            |<   |-'  |-<  |-    `-.   `-.
            | \  |    |  \ |    .   ) .   )
            '  ` '    '  ' `--'  `-'   `-'
        """.trimIndent()
    }
}
