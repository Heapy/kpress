package io.heapy.kpress.fs

import io.heapy.kpress.extensions.logger
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.util.ArrayList

/**
 * Contains file processing helpers.
 *
 * I decide to make all utils plain spring bean to simplify testing and overall consistency.
 *
 * @author Ruslan Ibragimov
 */
class FileService {

    /**
     * Copy all files from path
     *
     * @param path
     * @return
     */
    fun copyFolder(path: String): Boolean {
        return false
    }

    /**
     * Return list of [Path]s that contains all files in provided directory and subdirectories.
     *
     * @param folder directory from which we starting scan.
     * @return list of [Pair]s: left in pair - folder, right - file.
     */
    fun scanFolder(folder: Path): List<Pair<Path, Path>> {
        val paths = ArrayList<Pair<Path, Path>>()
        try {
            Files.list(folder).forEach { path ->
                when {
                    Files.isDirectory(path) -> paths.addAll(scanFolder(path))
                    Files.isRegularFile(path) -> paths.add(Pair(folder, path))
                    else -> LOGGER.error("Hmmmm, '{}'", path.toAbsolutePath())
                }
            }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }

        return paths
    }

    companion object {
        private val LOGGER = logger<FileService>()
    }
}
