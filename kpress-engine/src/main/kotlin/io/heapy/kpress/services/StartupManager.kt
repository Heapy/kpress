package io.heapy.kpress.services

/**
 * Used for running code on application startup.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface StartupManager {
    suspend fun start()
}

class DefaultStartupManager(
    private val listeners: List<StartupListener>
) : StartupManager {
    override suspend fun start() {
        listeners.forEach {
            it.onStartup()
        }
    }
}

/**
 * Listener will be executed on application startup.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface StartupListener {
    suspend fun onStartup()
}
