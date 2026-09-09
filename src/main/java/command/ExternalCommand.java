package command;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Vector;

public class ExternalCommand {

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

    public static void run(Vector<String> args) {
        Path fullPath = findInPath(args.getFirst());
        if (fullPath == null) {
            System.out.println(args.getFirst() + ": command not found");
            return;
        }

        try {
            ProcessBuilder builder = new ProcessBuilder(args);
            builder.inheritIO();
            Process process = builder.start();
            int exitCode = process.waitFor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
