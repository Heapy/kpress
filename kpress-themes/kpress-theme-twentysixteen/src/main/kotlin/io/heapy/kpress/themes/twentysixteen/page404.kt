package io.heapy.kpress.themes.twentysixteen

import io.heapy.kpress.api.Model
import io.heapy.kpress.api.i18n
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.dom.document
import kotlinx.html.dom.serialize
import kotlinx.html.h1
import kotlinx.html.header
import kotlinx.html.html
import kotlinx.html.id
import kotlinx.html.input
import kotlinx.html.p
import kotlinx.html.role
import kotlinx.html.section

/**
 * The template for displaying 404 pages (not found)
 *
 * @author Ibragimov Ruslan
 * @since Twenty Sixteen 1.0
 */
fun page404Impl(model: Model): String {
    return document {
        append.html {
            getHeader()
            body {
                div("content-area") {
                    id = "primary"

                    main("site-main") {
                        id = "main"
                        role = "main"

                        section("error-404 not-found") {
                            header("page-header") {
                                h1("page-title") {
                                    +i18n("Oops! That page can't be found.")
                                }
                            }

                            div("page-content") {
                                p {
                                    +"It looks like nothing was found at this location. Maybe try a search?"
                                }

                                input {
                                    placeholder = "get_search_form"
                                }
                            }
                        }
                    }

                    getSidebar("content-bottom")
                }
                getSidebar()
                getFooter()
            }

        }
    }.serialize()
}
