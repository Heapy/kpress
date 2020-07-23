package io.heapy.kpress.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

/**
 * Factory which assigns human-readable names to threads.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
private val threadFactory = object : ThreadFactory {
    private val threadNo = AtomicInteger()

    override fun newThread(runnable: Runnable): Thread {
        return Thread(runnable).also {
            it.name = "Elastic Context-${threadNo.incrementAndGet()}"
        }
    }
}

/**
 * Used for IO operations, since number of threads here unlimited.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
val elasticContext = Executors.newFixedThreadPool(
    Runtime.getRuntime().availableProcessors().coerceAtLeast(4),
    threadFactory
).asCoroutineDispatcher()

/**
 * Shorthand for running code in [elasticContext].
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
suspend fun <T> elastic(
    block: suspend CoroutineScope.() -> T
): T = withContext(elasticContext, block)
