package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userNumbers;

    public int checkInt(String input) {
        int inputNumbers;
        try {
            inputNumbers = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 이외의 값 입력");
        }
        return inputNumbers;
    }

    public void checkNumber(int inputNumbers) {
        if (inputNumbers < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력");
        }
        userNumbers = new ArrayList<>();
        int number = 0;
        for (int i = 100; i > 0; i = i / 10) {
            number = (inputNumbers % i * 10) / i;
            if (userNumbers.contains(number) || number == 0) {
                throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력");
            }
            userNumbers.add(number);
        }
    }

    public String judgement() {

        return "";
    }
}
