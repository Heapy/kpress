package by.heap.kpress.generator.markup

import org.asciidoctor.Asciidoctor
import org.asciidoctor.OptionsBuilder
import java.io.File

/**
 * Converts input data to html markup.

 * @author Ruslan Ibragimov
 */
class AsciiDocEngine {
    private val asciidoctor = Asciidoctor.Factory.create()

    fun convert(file: File): AsciiDocConversionDto {
        val optionsBuilder = OptionsBuilder.options().inPlace(false)
        val fileContent = file.readText()
        val content = asciidoctor.convert(fileContent, optionsBuilder)

        return AsciiDocConversionDto(content, asciidoctor.readDocumentHeader(file))
    }
}
