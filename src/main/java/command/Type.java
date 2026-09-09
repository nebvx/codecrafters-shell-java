package command;

import util.FindPath;

import java.nio.file.Path;

public class Type {
    String command;
    public Type(String command) {
        this.command = command;
    }

    public void run() {
        if (isCommandInBuiltin()) {
            System.out.println(command + " is a shell builtin");
        } else {
            Path fullPath = FindPath.findInPath(command);
            if (fullPath != null) {
                System.out.println(command + " is " + fullPath);
            } else {
                System.out.println(command + ": not found");
            }
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
