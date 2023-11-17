package baseball;

public class Application {
    public static void main(String[] args) {
        ComputerNumber computerNumber = new ComputerNumber();
        Game game = new Game(computerNumber);
        InputView inputView = new InputView(game);
        OutputView outputView = new OutputView(game);
        boolean gameStart = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameStart) {
            String result = inputView.readNumber();
            gameStart = outputView.printResult(result);
        }
    }
}
