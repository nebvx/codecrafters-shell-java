package navigation;

//The pwd (print working directory) builtin prints the full, absolute path of the current working directory to stdout.
public class Pwd {

    public Pwd() {

    }

    public void run() {
        System.out.println(System.getProperty("user.dir"));
    }
}
