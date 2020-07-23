package io.heapy.kpress.generator.markup

import io.heapy.kpress.extensions.elastic
import io.heapy.kpress.extensions.elasticContext
import io.heapy.kpress.extensions.logger
import io.heapy.kpress.model.Model
import io.heapy.kpress.services.ShutdownManager
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import org.asciidoctor.Asciidoctor
import org.asciidoctor.OptionsBuilder

/**
 * Converts input data to html markup.

 * @author Ruslan Ibragimov
 */
class AsciiDocEngine(
    shutdownManager: ShutdownManager
) : MarkupEngine {
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

    private val asciidoctor = GlobalScope.async(elasticContext, start = CoroutineStart.LAZY) {
        LOGGER.info("Creating asciidoctor... May take a while")
        Asciidoctor.Factory.create().also {
            LOGGER.info("Allons-y! Asciidoctor ${it.asciidoctorVersion()} created!")
        }
    }

    override suspend fun convert(model: Model, content: String): String = elastic {
        val optionsBuilder = OptionsBuilder.options().inPlace(false)
        asciidoctor.await().convert(content, optionsBuilder)
    }

    companion object {
        private val LOGGER = logger<AsciiDocEngine>()
    }
}
