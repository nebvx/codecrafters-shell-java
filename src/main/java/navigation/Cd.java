package navigation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import static util.FindPath.findInPath;

public class Cd {
    String commandPath;

    public Cd(String commandPath) {
        this.commandPath = commandPath;
    }

    public void run() {
        Path path =  Paths.get(commandPath);
        if (Files.exists(path) && Files.isDirectory(path)) {
            System.setProperty("user.dir", commandPath);
        } else {
            System.out.println("cd: " + path + ": No such file or directory");
        }
    }
}
