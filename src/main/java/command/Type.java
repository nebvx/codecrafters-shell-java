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
        } else {
            System.out.println(command + ": not found");
        }
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
