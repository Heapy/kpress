package io.heapy.kpress.koin

import org.koin.dsl.module.Module
import org.koin.standalone.StandAloneContext

/**
 * Function for running application.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
inline fun <reified T : Any> startKpress(vararg modules: Module, block: T.() -> Unit) {
    val logger = KoinLoggerAdapter()
    val context = StandAloneContext.startKoin(
        list = modules.toList(),
        logger = logger
    )

    block(context.koinContext.get())
}
