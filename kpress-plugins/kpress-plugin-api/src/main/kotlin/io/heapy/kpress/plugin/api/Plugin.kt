package io.heapy.kpress.plugin.api


import java.util.EventListener

/**
 * Base class for implementing by plugin developers.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Plugin {

    val namespace: String

    fun addEventListener(listener: EventListener)
}

/*

hello_dolly: `() -> String`

add_action('admin_notices', 'hello_dolly');
add_action( 'admin_head', 'dolly_css' );
 */
