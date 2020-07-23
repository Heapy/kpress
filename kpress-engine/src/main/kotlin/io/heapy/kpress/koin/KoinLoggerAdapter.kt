package io.heapy.kpress.koin

import io.heapy.kpress.extensions.logger
import org.koin.log.Logger

/**
 * Send Loggin events from [org.koin.core.Koin] to [org.slf4j.Logger].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class KoinLoggerAdapter : Logger {
    override fun debug(msg: String) {
        LOGGER.debug(msg)
    }

    override fun err(msg: String) {
        LOGGER.error(msg)
    }

    override fun info(msg: String) {
        LOGGER.info(msg)
    }

    companion object {
        private val LOGGER = logger<KoinLoggerAdapter>()
    }
}
