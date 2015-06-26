package by.ibragimov.jpress.generator.markup;

import com.google.common.base.Preconditions;
import org.asciidoctor.ast.DocumentHeader;

/**
 * Dto to holds result of conversion of AsciiDoc files.
 *
 * @author Ibragimov Ruslan
 */
public final class AsciiDocConversionDto {

    public AsciiDocConversionDto(String document, DocumentHeader documentHeader) {
        Preconditions.checkNotNull(document, "Document after conversion should be not null.");
        Preconditions.checkNotNull(documentHeader, "DocumentHeader after conversion should be not null.");
        this.document = document;
        this.documentHeader = documentHeader;
    }

    private final String document;

    private final DocumentHeader documentHeader;

    public String getDocument() {
        return document;
    }

    public DocumentHeader getDocumentHeader() {
        return documentHeader;
    }
}
