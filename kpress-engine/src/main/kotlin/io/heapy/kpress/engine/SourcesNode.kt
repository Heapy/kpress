package io.heapy.kpress.engine

sealed interface SourcesNode {
    val name: String
}

sealed interface FileNode : SourcesNode

sealed interface DirectoryNode : SourcesNode {
    val children: Map<String, SourcesNode>
}

data class LocalFileNode(
    override val name: String
) : FileNode

data class LocalDirectoryNode(
    override val name: String,
    override val children: MutableMap<String, SourcesNode>
) : DirectoryNode
