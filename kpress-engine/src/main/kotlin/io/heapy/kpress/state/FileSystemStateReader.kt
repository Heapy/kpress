package io.heapy.kpress.state

import io.heapy.kpress.extensions.logger
import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.FileVisitor
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.attribute.BasicFileAttributes

interface StateReader {
    fun read(path: Path): FsState
}

class FileSystemStateReader : StateReader {
    override fun read(path: Path): FsState {
        val fs = mutableMapOf<Path, FsObject>()

        Files.walkFileTree(path, object: FileVisitor<Path> {
            override fun preVisitDirectory(dir: Path, attrs: BasicFileAttributes): FileVisitResult {
                dir.toRealPath().let {
                    LOGGER.debug("Visiting ${path.relativize(dir)}")
                    fs[it] = Folder(it)
                }
                return FileVisitResult.CONTINUE
            }

            override fun postVisitDirectory(dir: Path, exc: IOException?): FileVisitResult {
                LOGGER.debug("Leaving  ${path.relativize(dir)}")

                if (exc != null) {
                    LOGGER.error("Visiting folder ${path.relativize(dir)} failed with exception", exc)
                }

                return FileVisitResult.CONTINUE
            }

            override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
                LOGGER.debug("Visiting file ${path.relativize(file)}")
                fs[file] = File(file)
                return FileVisitResult.CONTINUE
            }

            override fun visitFileFailed(file: Path, exc: IOException): FileVisitResult {
                LOGGER.error("Visiting file ${path.relativize(file)} failed with exception", exc)
                return FileVisitResult.CONTINUE
            }
        })

        return DefaultFsState(fs)
    }

    companion object {
        private val LOGGER = logger<FileSystemStateReader>()
    }
}
