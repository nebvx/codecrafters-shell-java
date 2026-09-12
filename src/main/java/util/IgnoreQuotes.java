package util;

import java.util.Vector;

public class IgnoreQuotes {
    Vector<String> userInput;

    public IgnoreQuotes(Vector<String> userInput) {
        this.userInput = userInput;
    }

    public Vector<String> freeInputFromQuotes() {
        Vector<String> userInputClean = new Vector<>();
        for (int i = 1; i < userInput.size(); i++) {
            if (i > 1) {
                userInput.add(" ");
            }

            String nextInput = userInput.get(i);
            StringBuilder builder = new StringBuilder();
            if (nextInput.charAt(0) == '\'') {
                for (int j = 1; j < nextInput.length(); ++j) {
                    if (nextInput.charAt(j) == '\'') break;
                    builder.append(nextInput.charAt(j));
                }
            } else {
                builder.append(nextInput);
            }

            userInputClean.add(builder.toString());
        }

        return userInputClean;
    }
}
