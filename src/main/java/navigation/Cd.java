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
        if(commandPath.charAt(0) == '/') { //absolute path
            cdWithAbsolutePath();
        } else if(commandPath.charAt(0) == '~'){
            cdToHomeDirectory();
        } else { //relative path
            cdWithRelativePath();
        }
    }

    private void cdWithAbsolutePath() {
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            System.err.println("cd: " + path + ": No such file or directory");
        }

        System.setProperty("user.dir", commandPath);
    }

    private void cdToHomeDirectory() {
        String homeDir = System.getProperty("user.home");
        System.setProperty("user.dir", homeDir);
    }

    //relative paths, like ./, ../, ./dir
    private void cdWithRelativePath() {
        Path absolutePath = Paths.get(System.getProperty("user.dir"), commandPath).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath) || !Files.isDirectory(absolutePath)) {
            System.err.println("cd: " + absolutePath + ": No such file or directory");
        }
        System.setProperty("user.dir", absolutePath.toString());
    }

}
