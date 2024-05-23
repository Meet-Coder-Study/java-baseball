package baseball.factory;

import baseball.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseBallNumberFactoryTest {

    @DisplayName("숫자 값을 통해 해당 Number 객체를 조회할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    void valueOfTest(final int number) {
        assertThat(BaseBallNumberFactory.valueOf(number)).isEqualTo(new Number(number));
    }

    @DisplayName("숫자가 1부터 9까지의 숫자가 아닌 경우에 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void valueOfExceptionTest(final int number) {
        assertThatThrownBy(() -> BaseBallNumberFactory.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 9까지의 숫자만 입력 가능합니다.");
    }

    @DisplayName("해당 팩토리의 List의 인덱스로 해당 값을 찾아올 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8})
    void valueOfIndex(final int index) {
        assertThat(BaseBallNumberFactory.valueOfIndex(index)).isEqualTo(new Number(index + 1));
    }
}
