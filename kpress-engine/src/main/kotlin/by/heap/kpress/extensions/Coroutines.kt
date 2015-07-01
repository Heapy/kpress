package by.heap.kpress.extensions

import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.asCoroutineDispatcher
import kotlinx.coroutines.experimental.withContext
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
 * Context used for blocking operations.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
private val elasticContext = Executors.newCachedThreadPool(threadFactory).asCoroutineDispatcher()

suspend fun <T> elastic(
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend () -> T
): T = withContext(elasticContext, start, block)
