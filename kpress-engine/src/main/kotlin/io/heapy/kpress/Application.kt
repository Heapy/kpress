package io.heapy.kpress

import io.heapy.kpress.extensions.logger
import kotlinx.coroutines.runBlocking
import java.time.Duration
import kotlin.system.measureNanoTime

/**
 * Entry point of application.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        val time = measureNanoTime {
            try {
                ApplicationModule().main.start()
            } catch (e: Throwable) {
                LOGGER.error("An exception occurred.", e)
            }
        }

        LOGGER.info("Spent time: ${Duration.ofNanos(time).seconds}s")
    }

    private val LOGGER = logger<Application>()
}
