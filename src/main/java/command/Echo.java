package command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

public class Echo {
    //The echo builtin prints its arguments to stdout, with spaces between them, and a newline (\n) at the end

    public Echo() {

    }

    public void run(Vector<String> userInput) {
        for (int i = 1; i < userInput.size(); i++) {
            if (i > 1) System.out.print(" ");
            System.out.print(userInput.get(i));
        }
        System.out.println();
    }
}
