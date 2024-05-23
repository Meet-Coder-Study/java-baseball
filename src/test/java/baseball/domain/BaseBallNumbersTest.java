package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BaseBallNumbersTest {

    private BaseBallNumbers incorrectBaseBallNumbers;

    @BeforeEach
    void setUp() {
        incorrectBaseBallNumbers = new BaseBallNumbers(List.of(
                new Number(1),
                new Number(2),
                new Number(3))
        );
    }

    @DisplayName("해당 Number가 포함되어 있다면 True다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void isContainsTrueTest(final int number) {
        assertThat(incorrectBaseBallNumbers.isContains(new Number(number))).isTrue();
    }

    @DisplayName("해당 Number가 포함되어 있지 않다면 False다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void isContainsFalseTest(final int number) {
        assertThat(incorrectBaseBallNumbers.isContains(new Number(number))).isFalse();
    }

    @DisplayName("같은 위치에 같은 숫자가 있으면 True다.")
    @Test
    void isSameIndexOfTrueTest() {
        assertThat(incorrectBaseBallNumbers.isSameIndexOf(new Number(1), 0)).isTrue();
    }

    @DisplayName("위치에 다른 숫자가 있으면 True다.")
    @Test
    void isSameIndexOfFalseTEst() {
        assertThat(incorrectBaseBallNumbers.isSameIndexOf(new Number(1), 1)).isFalse();
    }

    @DisplayName("해당 숫자의 인덱스를 조회할수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"1, 0", "2, 1", "3, 2"}, delimiter = ',')
    void indexOfTest(final int number, final int index) {
        assertThat(incorrectBaseBallNumbers.indexOf(new Number(number))).isEqualTo(index);
    }

    @DisplayName("중복된 값이 있으면 예외가 발생한다.")
    @Test
    void validateDuplicateNumbersExceptionTest() {
        final List<Number> numbers = List.of(new Number(1), new Number(2), new Number(2));

        assertThatThrownBy(() -> new BaseBallNumbers(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 있습니다.");
    }

    @DisplayName("중복값이 없으면 예외가 발생하지 않는다.")
    @Test
    void validateDuplicateNumbersNoExceptionTest() {
        final List<Number> numbers = List.of(new Number(1), new Number(2), new Number(3));

        assertDoesNotThrow(() -> new BaseBallNumbers(numbers));
    }

    @DisplayName("number가 2개 이하가 들어가는 경우 에러가 발생한다.")
    @Test
    void validateSizeLessThanTwoExceptionTest() {
        final List<Number> numbers = List.of(new Number(1), new Number(2));

        assertThatThrownBy(() -> new BaseBallNumbers(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자를 입력해주세요.");
    }

    @DisplayName("number가 4개 이상이 들어가는 경우 에러가 발생한다.")
    @Test
    void validateSizeMoreThanFourExceptionTest() {
        final List<Number> numbers = List.of(new Number(1),
                new Number(2),
                new Number(3),
                new Number(4));
        assertThatThrownBy(() -> new BaseBallNumbers(numbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3개의 숫자를 입력해주세요.");
    }
}
