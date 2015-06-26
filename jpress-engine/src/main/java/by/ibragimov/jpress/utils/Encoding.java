package by.ibragimov.jpress.utils;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public enum Encoding {

    UNICODE("UTF-8");

    private String encoding;

    Encoding(String encoding) {
        this.encoding = encoding;
    }

    @Override
    public String toString() {
        return encoding;
    }
}
