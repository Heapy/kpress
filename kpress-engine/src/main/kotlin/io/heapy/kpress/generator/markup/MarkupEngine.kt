package io.heapy.kpress.generator.markup

import io.heapy.kpress.model.Model

/**
 * Represent different markup engines like markdown and asciidoc.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface MarkupEngine {
    suspend fun convert(model: Model, content: String): String
}
