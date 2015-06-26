package by.ibragimov.jpress.generator.template;

import java.util.Map;

/**
 * Interface that all template engines used in jpress should follow.
 *
 * @author Ibragimov Ruslan
 */
public interface TemplateEngine {

    /**
     * Render particular page using provided data and template.
     *
     * @param template path in classpath to template with theme prefix. example: jfifteen/404.jade
     * @param model object that used to fill template
     * @return fully rendered page
     */
    String render(final String template, final Map<String, Object> model);
}
