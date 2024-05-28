package org.example.client;

import java.util.Random;
import org.assertj.core.api.Assertions;
import org.example.exception.BaseBallException;
import org.example.message.BaseBallErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallValidatorTest {

    private static final Random random = new Random();

    @Test
    @DisplayName("게임 시작 번호로 1 혹은 9의 숫자가 들어오면 예외를 발생시키지 않는다.")
    void validateStartNumberSuccessWithNumberOneOrNine() {
        //given
        int one = 1;
        int nine = 9;

        //when, then
        Assertions.assertThatCode(() ->BaseBallValidator.gameStartEndNumberValidator(one))
            .doesNotThrowAnyException();
        Assertions.assertThatCode(() ->BaseBallValidator.gameStartEndNumberValidator(nine))
            .doesNotThrowAnyException();    }

    @Test
    @DisplayName("게임 시작 번호로 1 혹은 9의 이외의 숫자가 들어오면 예외가 발생한다.")
    void validateStartNumberFailWithoutNumberOneOrNine() {
        //given
        int numberNotOneOrNine = getRandomNumberNotOneOrNine();

        //when, then
        Assertions.assertThatThrownBy(() -> BaseBallValidator.gameStartEndNumberValidator(numberNotOneOrNine))
            .isInstanceOf(BaseBallException.class)
            .hasMessage(BaseBallErrorMessage.INVALID_START_OR_END_NUMBER);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 2413, 14222222, 222, 122, 155, 5512})
    @DisplayName("사용자가 입력한 숫자가 서로 다른 세자리 자연수가 아닌 경우 예외가 발생한다.")
    void validateStartNumberFailWithoutNumberOneOrNine(int userInput) {
        //given, when, then
        Assertions.assertThatThrownBy(() -> BaseBallValidator.validateClientNumber(userInput))
            .isInstanceOf(BaseBallException.class)
            .hasMessage(BaseBallErrorMessage.INVALID_USER_NUMBER_GUESS);
    }

    private int getRandomNumberNotOneOrNine() {
        int number = random.nextInt(1000);
        while (number == 1 || number == 9) {
            number = random.nextInt(1000);
        }
        return number;
    }

}
