package command;

import java.util.Vector;

public class Type {
    String command;
    public Type(String command) {
        this.command = command;
    }

    public void run() {
        if (isCommandinBuiltin()) {
            System.out.println(command + " is a shell builtin");
        } else {
            System.out.println(command + ": not found");
        }
    }

    private boolean isCommandinBuiltin() {
        for (Builtin builtin : Builtin.values()) {
            if (builtin.name().equals(command)) {
                return true;
            }
        }
        return false;
    }
}
