package by.heap.kpress.api

/**
 * Hook a function to a specific filter action.
 *
 *
 * kpress offers filter hooks to allow plugins to modify
 * various types of internal data at runtime.
 *
 *
 * A plugin can modify data by binding a callback to a filter hook. When the filter
 * is later applied, each bound callback is run in order of priority, and given
 * the opportunity to modify a value by returning a new value.
 *
 *
 * The following example shows how a callback function is bound to a filter hook.
 *
 *
 * Note that `$example` is passed to the callback, (maybe) modified, then returned:
 *
 *
 * function example_callback( $example ) {
 * // Maybe modify $example in some way.
 * return $example;
 * }
 * add_filter( 'example_filter', 'example_callback' );
 *
 *
 * Since WordPress 1.5.1, bound callbacks can take as many arguments as are
 * passed as parameters in the corresponding apply_filters() call. The `$accepted_args`
 * parameter allows for calling functions only when the number of args match.
 *
 *
 * Note: the function will return true whether or not the callback is valid.
 * It is up to you to take care. This is done for optimization purposes,
 * so everything is as quick as possible.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Filter<T> {

    fun filter(data: T): T

    /**
     * The name of the filter to hook the callback to.
     */
    fun tag(): String

    /**
     * Used to specify the order in which the functions
     * associated with a particular action are executed.
     *
     * Lower numbers correspond with earlier execution,
     * and functions with the same priority are executed
     * in the order in which they were added to the action.
     */
    fun priority(): Int = 42

    fun callback(): (T) -> Unit = {}
}
