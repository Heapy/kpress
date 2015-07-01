package by.heap.kpress.api

/**
 * Interface used for load
 * all themes available in classpath.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Theme {
    val name: String

    /**
     * The home page template, which is the front page by default. If you use a
     * static front page this is the template for the page with the latest posts.
     */
    fun home(model: Model): String?

    /**
     * The front page template
     */
    fun frontPage(model: Model): String?

    /**
     * The main template
     */
    fun index(model: Model): String?

    /**
     * The comments template
     */
    fun comments(model: Model): String?

    /**
     * The single post template. Used when a single post is queried. For this
     * and all other query templates, index.php is used if the query template is not present.
     *
     * The single post template used when a single post from a custom post type
     * is queried. For example, single-book.php would be used for displaying
     * single posts from the custom post type named "book". index.php is used
     * if the query template for the custom post type is not present.
     *
     * single-{post-type}
     */
    fun single(model: Model): String?

    /**
     * The page template. Used when an individual Page is queried.
     */
    fun page(model: Model): String?

    /**
     * The category template. Used when a category is queried.
     */
    fun category(model: Model): String?

    /**
     * The tag template. Used when a tag is queried.
     */
    fun tag(model: Model): String?

    /**
     * The term template. Used when a term in a custom taxonomy is queried.
     */
    fun taxonomy(model: Model): String?

    /**
     * The author template. Used when an author is queried.
     */
    fun author(model: Model): String?

    /**
     * The date/time template. Used when a date or time is queried.
     * Year, month, day, hour, minute, second.
     */
    fun date(model: Model): String?

    /**
     * The archive template. Used when a category, author, or date is queried.
     * Note that this template will be overridden by category.php, author.php,
     * and date.php for their respective query types.
     */
    fun archive(model: Model): String?

    /**
     * The search results template. Used when a search is performed.
     */
    fun search(model: Model): String?

    /**
     * Attachment template. Used when viewing a single attachment.
     */
    fun attachment(model: Model): String?

    /**
     * Image attachment template. Used when viewing a single image attachment.
     * If not present, attachment.php will be used.
     */
    fun image(model: Model): String?

    /**
     * The 404 Not Found template.
     * Used when WordPress cannot find a post or page that matches the query.
     */
    fun page404(model: Model): String?
}

