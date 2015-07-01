package by.heap.kpress.state

class FileSystemStateReader : StateReader {
    override fun read(path: String): State {
        return State()
    }
}