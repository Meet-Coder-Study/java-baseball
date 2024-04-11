package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NumberTest {

    @DisplayName("1부터 9까지의 숫자만 입력 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void validateRangeTrueTest(int number) {
        assertDoesNotThrow(() -> new Number(number));
    }

    @DisplayName("0또는 10이상인 값인 경우엔 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void validateRangeFalseTest(int number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능합니다.");
    }
}
