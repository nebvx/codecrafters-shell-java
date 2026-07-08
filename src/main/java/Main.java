import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        REPL shellLoop = new REPL();
        shellLoop.runLoop();
    }
}
