package by.ibragimov.jpress.generator.markup;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.OptionsBuilder;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * Converts input data to html markup.
 *
 * @author Ibragimov Ruslan
 */
@Service
public class AsciiDocEngine {

    private RunnableFuture<Asciidoctor> future = new FutureTask<>(Asciidoctor.Factory::create);

    public AsciiDocEngine() {
        future.run();
    }

    public AsciiDocConversionDto convert(File file) {
        try {
            Asciidoctor doc = future.get();
            return new AsciiDocConversionDto(doc.renderFile(file, OptionsBuilder.options()), doc.readDocumentHeader(file));
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
