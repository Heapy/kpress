package by.heap.kpress

import by.heap.kpress.application.KpressBanner
import by.heap.kpress.application.UndertowServer
import by.heap.kpress.extensions.logger
import by.heap.kpress.fs.FileService
import by.heap.kpress.generator.Generator
import by.heap.kpress.generator.markup.AsciiDocEngine
import by.heap.kpress.generator.template.FreemarkerEngine
import by.heap.kpress.model.Model
import by.heap.kpress.model.Settings
import by.heap.kpress.state.FileSystemStateReader
import by.heap.kpress.state.StateSaver
import kotlinx.coroutines.experimental.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Два вида логирования: полное и облегченное (--verbose) https://logback.qos.ch/manual/configuration.html https://stackoverflow.com/questions/16910955/programmatically-configure-logback-appender
 *
 * Выключение демона по ctrl+c
 *   - Запуск как standalone приложение
 *   - Запуск как gradle файл (через плагин?) https://docs.gradle.org/current/userguide/custom_plugins.html
 *      - можно определить темы/плагины как модули внутри проекта
 *
 * Страница со всеми страницами, записями, тэгами, логами, алиасами, статистикой.
 * Авторелоад с помощью вебсокетов + js на странице (сервер mode).
 *
 */
object Application {
    @JvmStatic
    fun main(args: Array<String>) = runBlocking {
        Runtime
            .getRuntime()
            .addShutdownHook(object : Thread() {
                override fun run() {
                    try {
                        println("Shouting down...")
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            })

        val time = measureTimeMillis {
            try {
                val configuration = DefaultConfiguration()

                val main = Main(
                    banner = KpressBanner(),
                    stateReader = FileSystemStateReader(),
                    stateSaver = StateSaver(),
                    server = UndertowServer(configuration.server),
                    generator = Generator(
                        AsciiDocEngine(),
                        arrayListOf(),
                        FreemarkerEngine(),
                        FileService(),
                        Settings(),
                        Model()
                    ),
                    configuration = configuration
                )

                main.start()
            } catch (e: Throwable) {
                LOGGER.error("An exception occurred:", e)
            }
        }

        LOGGER.info("Spend time: ${time / 1000}s")
    }

    private val LOGGER = logger<Application>()
}
