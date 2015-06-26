package by.ibragimov.jpress.generator.template;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.ClasspathTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * Converts input data and template to html.
 *
 * @author Ibragimov Ruslan
 */
@Service
public class JadeEngine implements TemplateEngine {

    private final JadeConfiguration configuration;

    public JadeEngine() {
        configuration = new JadeConfiguration();
        configuration.setTemplateLoader(new ClasspathTemplateLoader());
    }

    @Override
    public String render(final String template, final Map<String, Object> model) {
        try {
            JadeTemplate jadeTemplate = configuration.getTemplate(template);
            return configuration.renderTemplate(jadeTemplate, model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
