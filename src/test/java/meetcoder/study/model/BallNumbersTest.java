package meetcoder.study.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumbersTest {

    @DisplayName("1 ~ 9사이의 서로 다른 3개의 숫자로 BallNumbers를 생성한다.")
    @Test
    void shouldCreateBallNumbersWithValidNumbers() {
        // when
        BallNumbers created = BallNumbers.of(List.of(1, 2, 3));

        // then
        assertNotNull(created);
    }

    @DisplayName("1 ~ 9사이의 숫자가 아닌 경우, BallNumbers를 생성할 수 없다.")
    @Test
    void shouldThrowExceptionWhenNumbersAreOutOfRange() {
        // when
        ThrowingCallable of = () -> BallNumbers.of(List.of(1, 2, 10));

        // then
        assertThatIllegalArgumentException()
            .isThrownBy(of)
            .withMessage("BallNumber은 1~9사이의 숫자여야 합니다.");
    }

    @DisplayName("중복된 숫자가 있는 경우, BallNumbers를 생성할 수 없다.")
    @Test
    void shouldThrowExceptionWhenNumbersAreDuplicated() {
        // when
        ThrowingCallable of = () -> BallNumbers.of(List.of(1, 1, 2));

        // then
        assertThatIllegalArgumentException()
            .isThrownBy(of)
            .withMessage("야구 숫자는 1~9사이의 서로 다른 3자리 숫자여야 합니다.");
    }

    @DisplayName("BallNumbers가 가지고 있는 숫자를 추측하여, 추측 결과를 확인한다. (Case. 3스트라이크)")
    @Test
    void shouldReturnThreeStrikesWhenAllNumbersAndPositionsMatch() {
        // given
        BallNumbers target = BallNumbers.of(List.of(1, 2, 3));
        BallNumbers guessedNumber = BallNumbers.of(List.of(1, 2, 3));

        // when
        BaseballGuessResult result = target.evaluateGuess(guessedNumber);

        // then
        assertTrue(result.isAllStrike());
        assertThat(result.ballCount()).isEqualTo(0);
        assertThat(result.strikeCount()).isEqualTo(3);
    }

    @DisplayName("BallNumbers가 가지고 있는 숫자를 추측하여, 추측 결과를 확인한다.(Case. 3볼)")
    @Test
    void shouldReturnThreeBallsWhenAllNumbersMatchButPositionsDoNot() {
        // given
        BallNumbers target = BallNumbers.of(List.of(1, 2, 3));
        BallNumbers guessedNumber = BallNumbers.of(List.of(3, 1, 2));

        // when
        BaseballGuessResult result = target.evaluateGuess(guessedNumber);

        // then
        assertThat(result.ballCount()).isEqualTo(3);
        assertThat(result.strikeCount()).isEqualTo(0);
    }

    @DisplayName("BallNumbers가 가지고 있는 숫자를 추측하여, 추측 결과를 확인한다.(Case. 2볼 1스트라이크)")
    @Test
    void shouldReturnTwoBallsAndOneStrikeWhenTwoNumbersMatchButOnlyOnePositionMatches() {
        // given
        BallNumbers target = BallNumbers.of(List.of(1, 2, 3));
        BallNumbers guessedNumber = BallNumbers.of(List.of(1, 3, 2));

        // when
        BaseballGuessResult result = target.evaluateGuess(guessedNumber);

        // then
        assertThat(result.ballCount()).isEqualTo(2);
        assertThat(result.strikeCount()).isEqualTo(1);
    }

    @DisplayName("BallNumbers가 가지고 있는 숫자를 추측하여, 추측 결과를 확인한다.(Case. 낫싱)")
    @Test
    void shouldReturnNothingWhenNoNumbersMatch() {
        // given
        BallNumbers target = BallNumbers.of(List.of(1, 2, 3));
        BallNumbers guessedNumber = BallNumbers.of(List.of(4, 5, 6));

        // when
        BaseballGuessResult result = target.evaluateGuess(guessedNumber);

        // then
        assertThat(result.ballCount()).isEqualTo(0);
        assertThat(result.strikeCount()).isEqualTo(0);
    }


}
