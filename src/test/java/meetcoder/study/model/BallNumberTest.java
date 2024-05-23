package meetcoder.study.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallNumberTest {

    @DisplayName("1~9 사이의 숫자로 BallNumber를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void shouldCreateBallNumberWithValidNumber(int number) {
        // when
        BallNumber created = BallNumber.of(number);

        // then
        assertNotNull(created);
    }

    @DisplayName("1~9 사이의 숫자가 아닌 경우, BallNumber를 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    void shouldThrowExceptionWhenNumberIsOutOfRange(int invalidNumber) {
        // given

        // when
        ThrowingCallable of = () -> BallNumber.of(invalidNumber);

        // then
        assertThatIllegalArgumentException()
            .isThrownBy(of)
            .withMessage("BallNumber은 1~9사이의 숫자여야 합니다.");
    }

    @DisplayName("같은 숫자를 가진 BallNumber는 동등한 객체이다.")
    @Test
    void ballNumbersWithSameValueShouldBeEqual() {
        // given
        BallNumber ballNumber1 = BallNumber.of(1);
        BallNumber ballNumber2 = BallNumber.of(1);

        // when
        boolean isEqual = ballNumber1.equals(ballNumber2);

        // then
        assertTrue(isEqual);
    }

}
