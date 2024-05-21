package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    @DisplayName("숫자가 존재하면 true를 반환한다.")
    @Test
    void isBallTrueTest() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3));
        final Game game = new Game(numbers);
        final Number number = new Number(1);
        
        assertThat(game.isBall(number)).isTrue();
    }

    @DisplayName("숫자가 존재하지 않는다면 false를 반환한다.")
    @Test
    void isBallFalseTest() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3));
        final Game game = new Game(numbers);
        final Number number = new Number(4);

        assertThat(game.isBall(number)).isFalse();
    }

    @DisplayName("해당 숫자가 해당 위치에 존재하면 True를 반환한다.")
    @Test
    void isStrikeTrueTest() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3));
        final Game game = new Game(numbers);
        final Number number = new Number(1);

        assertThat(game.isStrike(number, 0)).isTrue();
    }

    @DisplayName("해당 숫자가 해당 위치에 존재하지 않으면 False를 반환한다.")
    @Test
    void isStrikeFalseTest() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3));
        final Game game = new Game(numbers);
        final Number number = new Number(2);

        assertThat(game.isStrike(number, 0)).isFalse();
    }

    @DisplayName("해당 숫자가 존재하지 않으면 False를 반환한다.")
    @Test
    void isStrikeFalseTest2() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3));
        final Game game = new Game(numbers);
        final Number number = new Number(4);

        assertThat(game.isStrike(number, 0)).isFalse();
    }
}
