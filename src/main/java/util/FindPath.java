package util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindPath {

    public static Path findInPath(String command) {
        String pathEnv = System.getenv("PATH");
        if (pathEnv == null || pathEnv.isEmpty()) {
            return null;
        }

        String[] directories = pathEnv.split(java.util.regex.Pattern.quote(File.pathSeparator));
        for (String dir : directories) {
            Path fullPath = Paths.get(dir, command);
            if (Files.exists(fullPath) && Files.isExecutable(fullPath)) {
                return fullPath;
            }
        }

        return null;
    }
}