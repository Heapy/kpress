package by.heap.kpress.state

class State {
    sealed class FileTree {
        class Folder(val content: List<FileTree>) : FileTree()
        class File : FileTree()
        object EmptyFolder : FileTree()
    }

    fun eval(tree: FileTree): List<FileTree> = when (tree) {
        is FileTree.Folder -> tree.content
        is FileTree.File -> listOf(tree)
        FileTree.EmptyFolder -> listOf(FileTree.EmptyFolder)
    }
}
