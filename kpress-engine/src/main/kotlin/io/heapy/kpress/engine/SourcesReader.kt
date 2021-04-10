package io.heapy.kpress.engine

/**
 * Reads sources of a site.
 * Can read of real or virtual file system, or remote store.
 */
interface SourcesReader {
    /**
     * @param id maybe anything depending on implementation: path on local machine, remote git repo, or url
     */
    fun read(id: String): Sources
}



