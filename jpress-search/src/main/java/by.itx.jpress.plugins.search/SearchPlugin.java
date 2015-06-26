package by.itx.jpress.plugins.search;

import by.itx.jpress.api.Plugin;

/**
 * Base class for implementing by plugin developers.
 *
 * @author Ibragimov Ruslan
 */
public class SearchPlugin extends Plugin {


    public SearchPlugin() {
        super("search");
        System.out.println("Search!");
    }


}