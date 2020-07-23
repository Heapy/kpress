package io.heapy.kpress.state

interface StateSaver {
    fun save(fs: VirtualFS)
}

class DefaultStateSaver : StateSaver {
    override fun save(fs: VirtualFS) {
    }
}
