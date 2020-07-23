package io.heapy.kpress.services.listeners

import io.heapy.kpress.extensions.logger
import io.heapy.kpress.services.StartupListener

/**
 * Prints kpress banner.
 *
 * https://devops.datenkollektiv.de/banner.txt/index.html
 *
 * @author Ruslan Ibragimov
 * @since 1.0
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
