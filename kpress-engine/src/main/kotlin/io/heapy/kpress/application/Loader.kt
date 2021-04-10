package io.heapy.kpress.application

import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

/**
 * API for loading Themes and Plugins.
 *
 * @author Ruslan Ibragimov
 * @since 0.1
 */
interface Loader {
    fun <T : Any> load(klass: KClass<T>): List<T>
}

class ClassPathLoader() : Loader {
    override fun <T : Any> load(klass: KClass<T>): List<T> {
        val classLoader = Thread.currentThread().contextClassLoader ?:
            throw KPressException("Classloader is null.")

        val resources = classLoader
            .getResources("kpress/${klass.qualifiedName}")
            .toList()

        return resources.flatMap { url ->
            url.readText()
                .lines()
                .filter(String::isNotBlank)
                .map { loadClass(it, classLoader) }
                .map { createClass<T>(it) }
        }
    }

    private fun loadClass(name: String, classLoader: ClassLoader): KClass<*> {
        return try {
            classLoader.loadClass(name).kotlin
        } catch (e: ClassNotFoundException) {
            throw KPressException("Error loading $name. Class not found.")
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T : Any> createClass(
        klass: KClass<*>
    ): T {
        // TODO: Inject dependencies in constructor
        return klass.primaryConstructor?.call() as T
    }
}
