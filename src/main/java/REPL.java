import java.util.Objects;
import java.util.Scanner;

public class REPL {
    Scanner scanner;

    // Read-Eval-Print Loop
    public REPL() {

    }

    public void runLoop() {
        while (true) {
            System.out.print("$ ");
            scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            System.out.println(userInput + ": command not found");
            if (Objects.equals(userInput, "exit")) break;
        }
    }

}
