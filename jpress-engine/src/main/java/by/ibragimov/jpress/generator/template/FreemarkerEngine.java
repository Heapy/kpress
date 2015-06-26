package by.ibragimov.jpress.generator.template;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.function.Function;

/**
 * Used to convert "*.ftl" templates.
 *
 * @author Ibragimov Ruslan
 */
@Service
public class FreemarkerEngine implements TemplateEngine {

    private final Configuration configuration;

    public FreemarkerEngine() {
        configuration = new Configuration(Configuration.getVersion());
        configuration.setTemplateLoader(new ClassTemplateLoader(getClass(), "/"));
    }

    @Override
    public String render(final String template, final Map<String, Object> model) {
        try {
            Template freemarkerTemplate = configuration.getTemplate(template);
            StringWriter writer = new StringWriter();

            Function<String, String> function = (string) -> string;

            model.put("helper", function);

            freemarkerTemplate.process(model, writer);
            return writer.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
}
