package by.ibragimov.jpress.model.helpers;

import by.ibragimov.jpress.utils.Warnings;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

/**
 * Converts input to specified language
 *
 * @author Ibragimov Ruslan
 */
@Component
public class InternationalizationHelper implements Helper {

    /**
     * Returns localized string using input English string.
     *
     * @param string english string to localize.
     *
     * @return localized string.
     */
    @SuppressWarnings(Warnings.UNUSED)
    public String __(final String string) {
        // TODO: Implement logic with po and mo files using GNU gettext
        return "!!!" + string;
    }

    @Override
    public String getName() {
        return "i18n";
    }
}
