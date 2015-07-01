package by.heap.kpress.model

/**
 * Holds all Blog settings.

 * @author Ruslan Ibragimov
 */
class Settings {

    fun getString(key: String, default: String): String {
        return default
    }

    fun getInt(key: String, default: Int): Int {
        return default
    }

    fun getBoolean(key: String, default: Boolean): Boolean {
        return default
    }
}
