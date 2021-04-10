package io.heapy.kpress.application

/**
 * Used for running code on application startup.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
interface StartupManager {
    suspend fun start()
}

internal class DefaultStartupManager(
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
 * @since 0.1
 */
interface StartupListener {
    suspend fun onStartup()
}
