package by.ibragimov.jpress.metadata;

/**
 * TODO: CommentMe! ok
 *
 * @author Ibragimov Ruslan
 */
public class Value {

    private String name;
    private String developer;

    public Value(String name, String developer) {
        this.name = name;
        this.developer = developer;
    }

    public String getName() {
        return name;
    }

    public String getDeveloper() {
        return developer;
    }

}
