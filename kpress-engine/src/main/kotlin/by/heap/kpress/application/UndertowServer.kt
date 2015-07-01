package by.heap.kpress.application

import by.heap.kpress.ServerConfiguration
import by.heap.kpress.extensions.logger
import io.undertow.Undertow
import io.undertow.server.handlers.resource.PathResourceManager
import io.undertow.server.handlers.resource.ResourceHandler
import java.nio.file.Paths

/**
 * Used to stop running http server.
 */
typealias FileServiceStopHandler = () -> Unit

/**
 *
 */
interface FileServer {
    /**
     *
     */
    fun start(): FileServiceStopHandler
}

class UndertowServer(
    private val configuration: ServerConfiguration
) : FileServer {

    override fun start(): FileServiceStopHandler {
        val path = Paths.get(configuration.path)
        val undertow = Undertow
            .builder()
            .addHttpListener(configuration.port, configuration.host)
            .setHandler(ResourceHandler(PathResourceManager(path)))
            .build()

        undertow.start()

        LOGGER.info("Server '${configuration.host}:${configuration.port}' started and host files from " +
            "folder '${path.toAbsolutePath()}'.")

        return { undertow.stop() }
    }

    companion object {
        private val LOGGER = logger<UndertowServer>()
    }
}
