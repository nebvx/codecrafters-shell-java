import command.Echo;
import command.UserInput;

import java.util.Vector;
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
            String userInputLine = scanner.nextLine();
            UserInput userInput = new UserInput(userInputLine);
            Vector<String> userInputVector = userInput.getUserInputVector();
            if (Objects.equals(userInputVector.getFirst(), "echo")) {
                Echo echo = new Echo();
                echo.run(userInput.getUserInputVector());
            }
            if (Objects.equals(userInputVector.getFirst(), "exit")) break;
            System.out.println(userInput + ": command not found");
        }
    }

}
