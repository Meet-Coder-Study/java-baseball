package meetcoder.study.util;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @DisplayName("표현식이 true인 경우, 예외가 발생하지 않는다.")
    @Test
    void checkArgumentTrue() {
        // then
        assertDoesNotThrow(() -> Validator.checkArgument(true, "예외가 발생하면 안됩니다."));
    }

    @DisplayName("표현식이 false인 경우, 예외가 발생한다.")
    @Test
    void checkArgumentFalse() {
        // given
        String errorMessage = "예외가 발생해야 합니다.";

        // when
        ThrowingCallable checkArgument = () -> Validator.checkArgument(false, errorMessage);

        // then
        assertThatIllegalArgumentException()
            .isThrownBy(checkArgument)
            .withMessage(errorMessage);
    }

}
