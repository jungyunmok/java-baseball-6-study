package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public ComputerNumber() {
        numbers = new ArrayList<>();
        randomGenerator();
    }

    /**
     * 1~9 중복되지 않는 숫자 생성 후 numbers에 삽입
     */
    public void randomGenerator() {
        numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
