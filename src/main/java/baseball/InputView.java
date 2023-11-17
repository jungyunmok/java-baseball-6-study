package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    Game game;

    public InputView(Game game) {
        this.game = game;
    }

    /**
     * 사용자 입력값 받아서 게임 시작
     *
     * @return
     */
    public String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return game.play(input);
    }
}
