package io.heapy.kpress.themes.twentysixteen

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.script

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since 0.1
 */
fun HTML.getHeader() {
    head {
        script(type = "application/javascript") {
            +"alert(1);"
        }
    }
}
