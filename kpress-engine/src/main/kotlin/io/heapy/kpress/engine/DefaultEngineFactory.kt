package io.heapy.kpress.engine

class DefaultEngineFactory : EngineFactory {
    override val sourcesReader: SourcesReader by lazy {
        LocalSourcesReader()
    }
}
