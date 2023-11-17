package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> userNumbers;
    private List<Integer> computerNumbers;
    private int strike;
    private int ball;

    public Game(ComputerNumber computerNumber) {
        this.computerNumbers = computerNumber.getNumbers();
    }

    public String play(String input) {
        String result = "";
        try {
            int inputNumbers = checkInt(input);
            checkNumber(inputNumbers);
            result = judgement();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1부터 9까지 중복되지 않는 3자리 숫자를 입력해주세요.");
        }
        return result;
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
        for (int i = 1000; i >= 10; i = i / 10) {
            number = (inputNumbers % i * 10) / i;
            if (userNumbers.contains(number) || number == 0) {
                throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력");
            }
            userNumbers.add(number);
        }
    }

    public String judgement() {
        strike = 0;
        ball = 0;
        count();
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

    public void count() {
        for (int i = 0; i < computerNumbers.size(); i++) {
            for (int j = 0; j < userNumbers.size();j++) {
                correctNumber(i,computerNumbers.get(i),j,userNumbers.get(j));
            }
        }
    }

    public void correctNumber(int comIndex, int comNumber, int userIndex, int userNumber) {
        if (comNumber == userNumber) {
            if (comIndex == userIndex) {
                strike++;
                return;
            }
            ball++;
        }
    }

    public boolean retry(String input) {
        try {
            int number = checkInt(input);
            if (number == 1)
                return true;
            if (number == 2)
                return false;
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 입력");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1 혹은 2를 입력해주세요.");
        }
        return true;
    }
}
