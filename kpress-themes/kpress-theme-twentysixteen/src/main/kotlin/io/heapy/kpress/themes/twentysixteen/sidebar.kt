package io.heapy.kpress.themes.twentysixteen

import kotlinx.html.BODY
import kotlinx.html.FlowContent
import kotlinx.html.div

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
fun FlowContent.getSidebar(name: String = "main") {
    div {
        +"Hello"
    }
}

fun BODY.getSidebar(name: String = "main") {
    div {
        +"Hello"
    }
}
