package io.heapy.kpress.application

import io.heapy.kpress.engine.extensions.logger
import io.undertow.Undertow
import io.undertow.server.handlers.resource.PathResourceManager
import io.undertow.server.handlers.resource.ResourceHandler
import java.nio.file.Paths

/**
 * Server used for serving site generated by kpress.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
interface FileServer {
    /**
     * Starts server.
     */
    fun start()
}

/**
 * Implementation which uses [Undertow] as server.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
class UndertowServer(
    private val configuration: ServerConfiguration,
    private val shutdownManager: ShutdownManager
) : FileServer {

    override fun start() {
        val servePath = Paths.get(configuration.path)
        val undertow = Undertow
            .builder()
            .addHttpListener(configuration.port, configuration.host)
            .setHandler(ResourceHandler(PathResourceManager(servePath)))
            .build()

        undertow.start()

        LOGGER.info("Server ${configuration.host}:${configuration.port} started.")
        LOGGER.info("Server host files from folder: '${servePath.toAbsolutePath()}'.")

        shutdownManager.onShutdown("Undertow") {
            undertow.stop()
        }
    }

    companion object {
        private val LOGGER = logger<UndertowServer>()
    }
}
