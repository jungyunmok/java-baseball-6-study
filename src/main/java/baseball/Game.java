package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;
    private int strike = 0;
    private int ball = 0;

    public Game(ComputerNumber computerNumber) {
        this.computerNumbers = computerNumber.getNumbers();
    }

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
        for (int i = 0; i < computerNumbers.size(); i++) {
            for (int j = 0; j < userNumbers.size(); j++) {
                count(computerNumbers.get(i), i, userNumbers.get(j), j);
            }
        }
        if (strike > 0) {
            if (ball > 0) {
                return strike + "스트라이크 " + ball + "볼";
            }
            return strike + "스트라이크";
        }
        if (ball > 0)
            return ball + "볼";
        return "낫싱";
    }

    public void count(int computerNum, int computerIndex, int userNum, int userIndex) {
        if (computerNum == userNum) {
            if (computerIndex == userIndex) {
                strike++;
                return;
            }
            ball++;
        }
    }
}
