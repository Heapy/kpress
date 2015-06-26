package by.ibragimov.jpress.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Holds all Blog settings.
 *
 * @author Ibragimov Ruslan
 */
@Component
public class Settings {

    @Value("${jpress.input:blog}")
    private String input;

    @Value("${jpress.output:output}")
    private String output;

    @Value("${jpress.language:en}")
    private String language;

    @Value("${jpress.template:jfifteen-jade/}")
    private String template;

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }

    public String getLanguage() {
        return language;
    }

    public String getTemplate() {
        return template;
    }
}
