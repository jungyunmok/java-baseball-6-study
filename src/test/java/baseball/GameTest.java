package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameTest {
    private ComputerNumber computerNumber;
    private Game game;

    @BeforeEach
    void setUp() {
        computerNumber = new ComputerNumber();
        game = new Game(computerNumber);
    }

    @DisplayName("잘못된 입력시 에러 메시지 출력")
    @ValueSource(strings = {"-123", "test", "999", "1234", "012"})
    @ParameterizedTest
    void 사용자_잘못된_입력(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.play(input);
        assertThat(out.toString()).contains("[ERROR]");
    }

    @DisplayName("String to int 잘못된 입력시 exception 발생")
    @ValueSource(strings = {"test", "문자입력", "ㅇㅇ"})
    @ParameterizedTest
    void 인트_변환_잘못된_입력(String input) {
        assertThatThrownBy(() -> game.checkInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되지 않는 1~9 사이 3자리 수가 아닐 경우 exception 발생")
    @ValueSource(ints = {1234, 999, 063, 000, 76543})
    @ParameterizedTest
    void 숫자_확인_잘못된_입력(int input) {
        assertThatThrownBy(() -> game.checkNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1 입력시 게임 재시작")
    @Test
    void 게임_재시작() {
        assertThat(game.retry("1")).isEqualTo(true);
    }

    @DisplayName("2 입력시 게임 종료")
    @Test
    void 게임_종료() {
        assertThat(game.retry("2")).isEqualTo(false);
    }

    @DisplayName("잘못된 입력시 exception 발생")
    @ValueSource(strings = {"3", "12", "quit", "0"})
    @ParameterizedTest
    void 게임_재시작_잘못된_입력(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        game.retry(input);
        assertThat(out.toString()).contains("[ERROR]");
    }
}