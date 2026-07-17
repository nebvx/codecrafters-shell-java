package command;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Type {
    String command;
    public Type(String command) {
        this.command = command;
    }
    //Files.isExecutable()
    public void run() {
        if (isCommandInBuiltin()) {
            System.out.println(command + " is a shell builtin");

        } else if(isCommandInPath()) {

        } else {
            System.out.println(command + ": not found");
        }
    }

    private boolean isCommandInPath() {
        String pathEnv = System.getenv("PATH");
        if (pathEnv == null || pathEnv.isEmpty()) {
            return false;
        }

        String[] directories = pathEnv.split(java.util.regex.Pattern.quote(File.pathSeparator));
        for (String dir : directories) {
            Path fullPath = Paths.get(dir, command);
            if (Files.exists(fullPath) && Files.isExecutable(fullPath)) {
                System.out.println(command + " is " + fullPath);
                return true;
            }
        }

        return false;
    }

    private boolean isCommandInBuiltin() {
        for (Builtin builtin : Builtin.values()) {
            if (builtin.name().equals(command)) {
                return true;
            }
        }
        return false;
    }
}
