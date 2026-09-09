package command;

import util.FindPath;
import java.nio.file.Path;
import java.util.Vector;

public class ExternalCommand {

    public static void run(Vector<String> args) {
        Path fullPath = FindPath.findInPath(args.getFirst());
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
