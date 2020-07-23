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
import io.heapy.kpress.services.StartupManager
import io.heapy.kpress.services.listeners.BannerStartupListener
import io.heapy.kpress.services.listeners.KoinStartupListener
import io.heapy.kpress.state.DefaultStateSaver
import io.heapy.kpress.state.FileSystemStateReader
import io.heapy.kpress.state.StateReader
import io.heapy.kpress.state.StateSaver
import org.koin.dsl.module.module
import org.koin.experimental.builder.create
import org.koin.experimental.builder.singleBy

/**
 * Create application module - define all beans.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
val kpress = module {
    singleBy<FileServer, UndertowServer>()
    singleBy<Configuration, DefaultConfiguration>()
    singleBy<ServerConfiguration, DefaultServerConfiguration>()
    singleBy<StartupManager, DefaultStartupManager>()
    singleBy<ShutdownManager, DefaultShutdownManager>()
    singleBy<MarkupEngine, AsciiDocEngine>()
    singleBy<StateSaver, DefaultStateSaver>()
    singleBy<StateReader, FileSystemStateReader>()

    single {
        listOf(
            create<KoinStartupListener>(),
            create<BannerStartupListener>()
        )
    }

    single { FileService() }
    single { Settings() }
    single { Model() }
    single { create<Generator>() }
    single { create<Main>() }
}
