package baseball;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    Game game;

    public OutputView(Game game) {
        this.game = game;
    }

    /**
     * 결과 출력하고 재시작 여부 확인
     *
     * @param result
     * @return
     */
    public boolean printResult(String result) {
        boolean gameStart = true;
        System.out.println(result);
        if (result.equals("3스트라이크")) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            gameStart = game.retry(input);
        }
        return gameStart;
    }
}
