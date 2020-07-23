package io.heapy.kpress.services.listeners

import io.heapy.kpress.services.ShutdownManager
import io.heapy.kpress.services.StartupListener
import org.koin.standalone.StandAloneContext

/**
 * Startup listeners that adds Koin closing at shutdown.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class KoinStartupListener(
    private val shutdownManager: ShutdownManager
) : StartupListener {
    override suspend fun onStartup() {
        shutdownManager.onShutdown("Koin") {
            StandAloneContext.stopKoin()
        }
    }
}
