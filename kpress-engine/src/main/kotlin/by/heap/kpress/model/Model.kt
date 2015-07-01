package by.heap.kpress.model

import by.heap.kpress.metadata.Post
import by.heap.kpress.model.functions.Function

import java.util.ArrayList
import java.util.HashMap

class Model {

    var model: MutableMap<String, Any> = HashMap()

    private val helpers: List<Function>? = null

    var posts: List<Post> = ArrayList()

    fun init() {
        // Put all helpers method to model
        helpers!!.forEach { helper -> model[helper.name] = helper }

        model["posts"] = posts
    }

}
