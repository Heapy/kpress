package by.heap.kpress.extensions

import kotlin.system.measureTimeMillis

/**
 * Used for logging time spend in different tasks.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
inline fun measure(name: String, block: () -> Unit) {
    val millis = measureTimeMillis(block)

}
