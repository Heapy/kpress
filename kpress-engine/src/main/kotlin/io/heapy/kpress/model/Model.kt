package io.heapy.kpress.model

import io.heapy.kpress.metadata.Post
import io.heapy.kpress.model.functions.Function

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
