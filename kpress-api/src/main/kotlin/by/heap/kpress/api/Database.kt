package by.heap.kpress.api

import kotlin.reflect.KClass

/**
 * Can be used by plugins/themes to store configuration or metadata.
 *
 * For example podcast plugin can save results of calculations of audio length.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
interface Database {

    /**
     * Get data from particular table database
     *
     * @param table - name of the table
     * @param key - key in table which identifies concrete row
     * @param klass - [KClass] used for deserialization
     *
     * @return deserialized data from database
     */
    fun <T : Any> get(table: String, key: String, klass: KClass<T>): T

    /**
     * @param table - name of the table
     * @param key - key in table which identifies concrete row
     * @param data - data to serialize
     */
    fun <T : Any> put(table: String, key: String, data: T)
}
