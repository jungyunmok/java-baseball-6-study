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

    public void randomGenerator() {
        numbers.clear();
        while (numbers.size() < Constant.MAXRANGE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
