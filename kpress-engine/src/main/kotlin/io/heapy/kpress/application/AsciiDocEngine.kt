package io.heapy.kpress.application

import io.heapy.kpress.engine.extensions.logger
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.asciidoctor.Asciidoctor
import org.asciidoctor.OptionsBuilder

/**
 * Converts input data to html markup.

 * @author Ruslan Ibragimov
 */
class AsciiDocEngine(
    shutdownManager: ShutdownManager
) {
    init {
        shutdownManager.onShutdown("Asciidoctor") {
            if (asciidoctor.isActive || asciidoctor.isCompleted) {
                if (asciidoctor.isActive) LOGGER.info("Await Asciidoctor creation to stop Asciidoctor...")
                if (asciidoctor.isCompleted) LOGGER.info("Stopping asciidoctor...")

                asciidoctor.await().shutdown()
                LOGGER.info("Thanks Matsumoto, Asciidoctor stopped")
            }

            if (!asciidoctor.isActive && !asciidoctor.isCompleted) {
                LOGGER.info("Lucky, looks like you doesn't used Asciidoctor this time")
            }
        }
    }

    private val asciidoctor = GlobalScope.async(Dispatchers.IO, start = CoroutineStart.LAZY) {
        LOGGER.info("Creating asciidoctor... May take a while")
        Asciidoctor.Factory.create().also {
            LOGGER.info("Allons-y! Asciidoctor ${it.asciidoctorVersion()} created!")
        }
    }

    suspend fun convert(content: String): String = withContext(Dispatchers.IO) {
        val optionsBuilder = OptionsBuilder.options().inPlace(false)
        asciidoctor.await().convert(content, optionsBuilder)
    }

    companion object {
        private val LOGGER = logger<AsciiDocEngine>()
    }
}
