package io.heapy.kpress

import io.heapy.kpress.application.FileServer
import io.heapy.kpress.generator.Generator
import io.heapy.kpress.services.StartupManager
import io.heapy.kpress.state.StateReader
import io.heapy.kpress.state.StateSaver
import java.nio.file.Paths

/**
 * Class whic
 */
class Main(
    private val stateReader: StateReader,
    private val stateSaver: StateSaver,
    private val generator: Generator,
    private val server: FileServer,
    private val configuration: Configuration,
    private val startupManager: StartupManager
) {
    suspend fun start() {
        startupManager.start()

        if (configuration.isServer) {
            server.start()

            while (true) {

            }
            // watch, diff, apply to state, generate, save
            // возможно стоит сделать очередь дифоф от файловой системы, выполнять генерацию асинхронно либо мержить
            // несколько последних стейтов в очереди и делать синхронную генерацию
        } else {
            // TODO: Validate read folder exists and is folder
            val state = stateReader.read(Paths.get("..", "..", "IRus", "blog", "content"))
            val generated = generator.generate(state)
            stateSaver.save(generated)
        }
    }
}
