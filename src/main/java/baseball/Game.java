package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userNumbers;

    public List<Integer> checkInt(String input) {
        int inputNumbers;
        try {
            inputNumbers = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
        userNumbers = new ArrayList<>();
        userNumbers.add(checkNumber(inputNumbers));
        return userNumbers;
    }

    public int checkNumber(int inputNumbers) {
        return 0;

    }
}
