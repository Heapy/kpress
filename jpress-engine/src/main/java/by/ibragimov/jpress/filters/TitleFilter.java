package by.ibragimov.jpress.filters;

import org.springframework.stereotype.Component;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@Component
public class TitleFilter implements JPressFilter<String> {

    @Override
    public String filter(String s) {
        return this.getClass().getCanonicalName();
    }
}
