package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Game game;
    public void readNumber() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        String result = game.play(input);
    }
}
