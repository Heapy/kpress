package by.ibragimov.jpress.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Contains file processing helpers.
 *
 * I decide to make all utils plain spring bean to simplify testing and overall consistency.
 *
 * @author Ibragimov Ruslan
 */
@Service
public class FileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileService.class);

    /**
     * Copy all files from path
     *
     * @param path
     * @return
     */
    public boolean copyFolder(final String path) {
        return false;
    }

    /**
     * Return list of {@link Path}s that contains all files in provided directory and subdirectories.
     *
     * @param folder directory from which we starting scan.
     * @return list of {@link Pair}s: left in pair - folder, right - file.
     */
    public List<Pair<Path, Path>> scanFolder(Path folder) {
        List<Pair<Path, Path>> paths = new ArrayList<>();
        try {
            Files.list(folder).forEach(path -> {
                if (Files.isDirectory(path)) {
                    paths.addAll(scanFolder(path));
                } else if (Files.isRegularFile(path)) {
                    paths.add(Pair.of(folder, path));
                } else {
                    LOGGER.error("Hmmmm, '{}'", path.toAbsolutePath());
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return paths;
    }
}
