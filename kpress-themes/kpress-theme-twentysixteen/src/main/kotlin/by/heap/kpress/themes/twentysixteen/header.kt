package by.heap.kpress.themes.twentysixteen

import kotlinx.html.HTML
import kotlinx.html.head
import kotlinx.html.script

/**
 * TODO.
 *
 * @author Ibragimov Ruslan
 * @since Twenty Sixteen 1.0
 */
fun HTML.getHeader() {
    head {
        script(type = "application/javascript") {
            +"alert(1);"
        }
    }
}
