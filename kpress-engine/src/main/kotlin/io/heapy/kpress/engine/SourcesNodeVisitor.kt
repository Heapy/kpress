package io.heapy.kpress.engine

import java.util.*

interface SourcesNodeVisitor {
    fun visitFile(
        rootNode: DirectoryNode,
        directoryNode: DirectoryNode,
        fileNode: FileNode
    )

    companion object
}

internal fun SourcesNodeVisitor.Companion.walk(
    rootNode: DirectoryNode,
    visitor: SourcesNodeVisitor
) {
    val stack = ArrayDeque(listOf(rootNode))

    while (stack.isNotEmpty()) {
        val node = stack.poll()

        node.children.forEach { (_, child) ->
            when (child) {
                is DirectoryNode -> stack.push(child)
                is FileNode -> visitor.visitFile(
                    rootNode = rootNode,
                    directoryNode = node,
                    fileNode = child
                )
            }
        }
    }
}
