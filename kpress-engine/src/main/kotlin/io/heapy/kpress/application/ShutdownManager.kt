package io.heapy.kpress.application

import io.heapy.kpress.engine.extensions.logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

/**
 * Used for graceful shutdown resources.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
interface ShutdownManager {
    fun onShutdown(what: String, callback: ShutdownCallback)
    fun shutdown()
    val isShutdown: Boolean
}

typealias ShutdownCallback = suspend () -> Unit

/**
 * Default coroutines backed implementation,
 * with parallel shutdown.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
internal class DefaultShutdownManager : ShutdownManager, StartupListener {
    private val callbacks: MutableList<Pair<String, ShutdownCallback>> = mutableListOf()

    override fun onShutdown(what: String, callback: ShutdownCallback) {
        callbacks.add(what to callback)
    }

    override fun shutdown() {
        if (_isShutdown.getAndSet(true)) {
            LOGGER.info("Shutdown already in progress")
            return
        }

        LOGGER.info("Stopping kpress...")

        runBlocking {
            callbacks.map {
                async(Dispatchers.IO) {
                    try {
                        LOGGER.info("Stopping ${it.first}...")
                        it.second()
                        LOGGER.info("${it.first} stopped...")
                    } catch (e: Exception) {
                        LOGGER.error("${it.first} stopped with exception", e)
                    }
                }
            }.forEach { it.await() }
        }

        LOGGER.info("Kpress stopped")
    }

    override suspend fun onStartup() {
        Runtime.getRuntime()
            .addShutdownHook(thread(start = false) {
                shutdown()
            })
    }

    private val _isShutdown = AtomicBoolean(false)

    override val isShutdown = _isShutdown.get()

    companion object {
        private val LOGGER = logger<DefaultShutdownManager>()
    }
}


