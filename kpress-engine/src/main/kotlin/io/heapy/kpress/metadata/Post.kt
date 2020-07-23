package io.heapy.kpress.metadata

import java.time.LocalDateTime

data class Post(
    val published: LocalDateTime,
    val category: Category,
    val content: String,
    val author: Author
)
