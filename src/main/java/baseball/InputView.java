package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Game game;

    public InputView(Game game) {
        this.game = game;
    }

    public String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return game.play(input);
    }
}
