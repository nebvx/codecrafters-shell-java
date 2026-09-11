package navigation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

import static util.FindPath.findInPath;

public class Cd {
    String commandPath;
    Path path;

    public Cd(String commandPath) {
        this.commandPath = commandPath;
        path = Paths.get(commandPath);
    }

    public void run() {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.err.println("cd: " + path + ": No such file or directory");
        }

        if(commandPath.charAt(0) == '/') { //absolute path
            cdWithAbsolutePath();
        } else if(commandPath.charAt(0) == '.') {
            if (commandPath.charAt(1) == '/') { //Current Directory
                cdWithCurrentDirectory();
            } else if (commandPath.charAt(1) == '.') { //Parent Directory
                cdWithParentDirectory();
            }
        } else { //is any letter
            cdWithCurrentDirectory();
        }
    }

    private void cdWithAbsolutePath() {
        System.setProperty("user.dir", commandPath);
    }

    private void cdWithCurrentDirectory() {
        Path absolutePath = Paths.get(System.getProperty("user.dir"), commandPath).toAbsolutePath().normalize();
        System.setProperty("user.dir", absolutePath.toString());
    }

    private void cdWithParentDirectory() {
        Path absolutePath = Paths.get(System.getProperty("user.dir"), commandPath).toAbsolutePath().normalize();
        System.setProperty("user.dir", absolutePath.toString());
    }
}
