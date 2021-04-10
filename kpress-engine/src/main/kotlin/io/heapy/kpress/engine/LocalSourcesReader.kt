package io.heapy.kpress.engine

import io.heapy.kpress.engine.extensions.logger
import java.io.IOException
import java.nio.file.*
import java.nio.file.attribute.BasicFileAttributes

internal class LocalSourcesReader : SourcesReader {
    override fun read(id: String): Sources {
        val rootDirectory = readFileTree(id)
        when (val content = rootDirectory.children["content"]) {
            is LocalDirectoryNode -> {
                SourcesNodeVisitor.walk(content, object : SourcesNodeVisitor {
                    override fun visitFile(
                        rootNode: DirectoryNode,
                        directoryNode: DirectoryNode,
                        fileNode: FileNode
                    ) {
                        TODO() // Map files to internal primitives such as: page, resource, section, etc
                    }
                })
            }
            is LocalFileNode -> TODO() // EMPTY
            null -> TODO() // EMPTY
        }

        return object : Sources {}
    }

    internal fun readFileTree(id: String): DirectoryNode {
        val root = Paths.get(id).toRealPath()
        val rootNode = LocalDirectoryNode(
            name = "",
            children = mutableMapOf()
        )

        Files.walkFileTree(root, object : FileVisitor<Path> {
            override fun preVisitDirectory(
                dir: Path,
                attrs: BasicFileAttributes
            ): FileVisitResult {
                LOGGER.trace("Visiting folder [$dir]")
                return FileVisitResult.CONTINUE
            }

            override fun postVisitDirectory(
                dir: Path,
                exc: IOException?
            ): FileVisitResult {
                LOGGER.trace("Leaving folder [$dir]")

                if (exc != null) {
                    LOGGER.error("Visiting folder $dir failed with exception", exc)
                }

                return FileVisitResult.CONTINUE
            }

            override fun visitFile(
                file: Path,
                attrs: BasicFileAttributes
            ): FileVisitResult {
                val relativePath = root.relativize(file)
                LOGGER.debug("Visiting file [$relativePath]")
                val parts = relativePath.toList()
                val folders = if (parts.size > 1) parts.dropLast(1) else listOf()
                val fileName = parts.last().toString()

                folders.fold(rootNode) { node, folder ->
                    val folderName = folder.toString()
                    node.children.computeIfAbsent(folderName) {
                        LocalDirectoryNode(
                            name = folderName,
                            children = mutableMapOf()
                        )
                    } as LocalDirectoryNode
                }.let { currentNode ->
                    currentNode.children[fileName] = LocalFileNode(
                        name = fileName
                    )
                }

                return FileVisitResult.CONTINUE
            }

            override fun visitFileFailed(
                file: Path,
                exc: IOException
            ): FileVisitResult {
                LOGGER.error("Visiting file [$file}] failed with exception", exc)
                return FileVisitResult.CONTINUE
            }
        })

        return rootNode
    }

    companion object {
        private val LOGGER = logger<LocalSourcesReader>()
    }
}
