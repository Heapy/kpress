package by.ibragimov.jpress;

import by.ibragimov.jpress.application.ApplicationConfiguration;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Entry point of jpress.
 */
public class Application {

    private static final Stopwatch STOPWATCH = Stopwatch.createStarted();

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    /**
     *
     * # Получение данных для блога
     * 0. В отдельном потоке инициализируем asciidoc engine
     * 1. Строим List из объектов содержащих путь к файлу и файл (поддерживаем adoc и html)
     * 2. Вычитываем методанные из файлов и файл, добавляем в объекты методанные и данные соответсвующего файла
     *
     * # В отдельном потоке копируем assets в dist
     *
     * # Шаблонизация
     * 1. Есть ряд шаблонов общего назначения (хидер, футер, сайдбар)
     * 2. Каждый шаблон содержив в себе вызов функции/переменные
     * 3. У разработчика должна быть возможность изменить <title> страницы из плагина, при этом он должен знать текущий контекст
     *      3.1 Для этого нужно добавть механизм регистрации фильтров/хуков/слушателей
     *      3.2 При получения значения title должена вызываться цепочка из зарегистрированных фильтров/хуков/слушателей
     *
     */
    public static void main(String[] args) {
        try {
            new Application().init();
        } catch (Throwable e) {
            LOGGER.error("An exception occurred:", e);
            System.exit(1);
        } finally {
            LOGGER.info("Spend time: {}", STOPWATCH.stop());
        }
    }

    private void init() {
        new AnnotationConfigApplicationContext(ApplicationConfiguration.class).start();
    }
}
