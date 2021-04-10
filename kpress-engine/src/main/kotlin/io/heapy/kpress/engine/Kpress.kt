@file:JvmName("Kpress")
package io.heapy.kpress.engine

import io.heapy.kpress.engine.extensions.logger
import java.time.Duration
import kotlin.system.measureNanoTime

fun main() {
    val logger = logger<DefaultEngineFactory>()
    val time = measureNanoTime {
        try {
            DefaultEngineFactory().sourcesReader.read("../blog")
        } catch (e: Throwable) {
            logger.error("An exception occurred.", e)
        }
    }

    logger.info("Spent time: ${Duration.ofNanos(time).seconds}s")
}
