package by.heap.kpress.extensions

import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified T : Any> logger(): Logger = LoggerFactory.getLogger(T::class.java)
