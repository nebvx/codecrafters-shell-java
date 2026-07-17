package command;

import java.util.Vector;

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
