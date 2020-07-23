package io.heapy.kpress.state

import java.nio.file.Path

/**
 * Every object in file system has path.
 * All paths relative root path.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
sealed class FsObject(
    val path: Path
)

/**
 * Represents folder on fs.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class Folder(
    path: Path
) : FsObject(path)

/**
 * Represent file on fs.
 *
 * @author Ruslan Ibragimov
 * @since 1.0
 */
class File(
    path: Path
) : FsObject(path)

/**
 * Represents state of site source folder.
 */
interface FsState {
    val files: Map<Path, FsObject>
}

class DefaultFsState(
    override val files: Map<Path, FsObject>
) : FsState
