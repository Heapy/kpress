package by.heap.kpress

import by.heap.kpress.application.Banner
import by.heap.kpress.application.UndertowServer
import by.heap.kpress.generator.Generator
import by.heap.kpress.state.StateReader
import by.heap.kpress.state.StateSaver
import kotlinx.coroutines.experimental.channels.actor

/**
 * # Получение данных для блога
 * 0. В отдельном потоке инициализируем asciidoc engine
 * 1. Строим List из объектов содержащих путь к файлу и файл (поддерживаем adoc и html)
 * 2. Вычитываем методанные из файлов и файл, добавляем в объекты методанные и данные соответсвующего файла
 * # В отдельном потоке копируем assets в dist
 * # Шаблонизация
 * 1. Есть ряд шаблонов общего назначения (хидер, футер, сайдбар)
 * 2. Каждый шаблон содержив в себе вызов функции/переменные
 * 3. У разработчика должна быть возможность изменить  страницы из плагина, при этом он должен знать текущий контекст
 * 3.1 Для этого нужно добавть механизм регистрации фильтров/хуков/слушателей
 * 3.2 При получения значения title должена вызываться цепочка из зарегистрированных фильтров/хуков/слушателей
 */
class Main(
    private val banner: Banner,
    private val stateReader: StateReader,
    private val generator: Generator,
    private val stateSaver: StateSaver,
    private val server: UndertowServer,
    private val configuration: Configuration
) {
    suspend fun start() {
        banner.print()

        val stopHandler = server.start()

        if (configuration.isServer) {
            val run = actor<String> {

            }

            while (true) {

            }
            // watch, diff, apply to state, generate, save
            // возможно стоит сделать очередь дифоф от файловой системы, выполнять генерацию асинхронно либо мержить
            // несколько последних стейтов в очереди и делать синхронную генерацию
        } else {
            val state = stateReader.read("/blog")
            val generated = generator.generate(state)
            stateSaver.save(generated)
        }
    }
}
