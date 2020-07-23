package io.heapy.kpress.api

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since TODO
 */
interface Model {
    val baseUrl: String
    val pager: Pager?
}

interface Pager {
    val current: Int
    val total: Int
}

fun Model.url(vararg paths: String): String {
    return (listOf(baseUrl) + paths).joinToString(separator = "/")
}

/**
 * Checks is current model contains pages.
 */
val Model.pageable: Boolean
    get() = pager != null
