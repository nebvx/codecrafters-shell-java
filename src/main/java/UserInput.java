import java.util.Vector;

public class UserInput {
    String userInput;
    Vector<String> userInputVector;

    public UserInput(String userInput) {
        this.userInput = userInput;
        this.userInputVector = separateUserInputBySpace();
    }

    public Vector<String> getUserInputVector() {
        return userInputVector;
    }

    private Vector<String> separateUserInputBySpace() {
        Vector<String> separatedInput = new Vector<>();
        StringBuilder wordBuilder = new StringBuilder();

        for(int i = 0; i < userInput.length(); ++i) {
            if (userInput.charAt(i) == ' ') {
                separatedInput.add(wordBuilder.toString());
                wordBuilder.setLength(0);
                continue;
            }

            wordBuilder.append(userInput.charAt(i));
        }
        separatedInput.add(wordBuilder.toString());
        return separatedInput;
    }
}
