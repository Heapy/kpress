package io.heapy.kpress

import io.heapy.kpress.application.FileServer
import io.heapy.kpress.application.UndertowServer
import io.heapy.kpress.fs.FileService
import io.heapy.kpress.generator.Generator
import io.heapy.kpress.generator.markup.AsciiDocEngine
import io.heapy.kpress.generator.markup.MarkupEngine
import io.heapy.kpress.model.Model
import io.heapy.kpress.model.Settings
import io.heapy.kpress.services.DefaultShutdownManager
import io.heapy.kpress.services.DefaultStartupManager
import io.heapy.kpress.services.ShutdownManager
import io.heapy.kpress.services.StartupListener
import io.heapy.kpress.services.StartupManager
import io.heapy.kpress.services.listeners.BannerStartupListener
import io.heapy.kpress.state.DefaultStateSaver
import io.heapy.kpress.state.FileSystemStateReader
import io.heapy.kpress.state.StateReader
import io.heapy.kpress.state.StateSaver

/**
 * Create application module - define all dependencies.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
open class ApplicationModule {
    open val fileServer: FileServer by lazy {
        UndertowServer(
            configuration = serverConfiguration,
            shutdownManager = shutdownManager,
        )
    }

    open val configuration: Configuration by lazy {
        DefaultConfiguration()
    }

    open val serverConfiguration: ServerConfiguration by lazy {
        DefaultServerConfiguration()
    }

    open val shutdownManager: ShutdownManager by lazy {
        DefaultShutdownManager()
    }

    open val startupManager: StartupManager by lazy {
        DefaultStartupManager(
            listeners = listOf(
                bannerStartupListener,
            )
        )
    }

    open val bannerStartupListener: StartupListener by lazy {
        BannerStartupListener()
    }

    open val markupEngine: MarkupEngine by lazy {
        AsciiDocEngine(
            shutdownManager = shutdownManager,
        )
    }

    open val stateSaver: StateSaver by lazy {
        DefaultStateSaver()
    }

    open val stateReader: StateReader by lazy {
        FileSystemStateReader()
    }

    open val fileService: FileService by lazy {
        FileService()
    }

    open val settings: Settings by lazy {
        Settings()
    }

    open val model: Model by lazy {
        Model()
    }

    open val generator: Generator by lazy {
        Generator(
            asciiDocEngine = markupEngine,
            fileService = fileService,
            settings = settings,
            model = model,
        )
    }

    open val main: Main by lazy {
        Main(
            stateReader = stateReader,
            stateSaver = stateSaver,
            generator = generator,
            server = fileServer,
            configuration = configuration,
            startupManager = startupManager,
        )
    }
}
