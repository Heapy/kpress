package by.itx.jpress.api.persistence;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
public interface Database<T extends Entry> {

    /**
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getData(String collection, String key, Class<T> clazz);


    <T> void putData(String key, String collection, T object);
}
