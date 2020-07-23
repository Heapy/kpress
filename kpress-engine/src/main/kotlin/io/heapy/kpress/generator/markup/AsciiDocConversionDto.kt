package io.heapy.kpress.generator.markup

import org.asciidoctor.ast.DocumentHeader

/**
 * Dto to holds result of conversion of AsciiDoc files.

 * @author Ruslan Ibragimov
 */
data class AsciiDocConversionDto(
    val document: String,
    val documentHeader: DocumentHeader
)
