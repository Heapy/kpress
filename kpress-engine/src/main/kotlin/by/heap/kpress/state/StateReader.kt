package by.heap.kpress.state

interface StateReader {
    fun read(path: String): State
}