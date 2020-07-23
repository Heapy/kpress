package io.heapy.kpress

import io.heapy.kpress.extensions.logger
import io.heapy.kpress.koin.startKpress
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Entry point of application.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        val time = measureTimeMillis {
            try {
                startKpress<Main>(kpress) { start() }
            } catch (e: Throwable) {
                Application.LOGGER.error("An exception occurred.", e)
            }
        }

        Application.LOGGER.info("Spent time: ${time / 1000}s")
    }

    private val LOGGER = logger<Application>()
}
