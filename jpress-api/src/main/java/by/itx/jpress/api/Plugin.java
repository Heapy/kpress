package by.itx.jpress.api;


/**
 * Base class for implementing by plugin developers.
 *
 * @author Ibragimov Ruslan
 */
public abstract class Plugin {

    private final String namespace;

    /**
     * Set name that will
     *
     * @param namespace
     */
    public Plugin(String namespace) {
        this.namespace = namespace;
    }

    public String getNamespace() {
        return namespace;
    }
}
