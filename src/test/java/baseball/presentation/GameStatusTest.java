package baseball.presentation;

import baseball.common.exception.InvalidGameStatusException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class GameStatusTest {

    @ParameterizedTest
    @CsvSource({
            "START, 1",
            "QUIT, 9"
    })
    void 유효한_번호를_입력하면_해당하는_게임상태를_반환한다(GameStatus gameStatus, String description) throws InvalidGameStatusException {
        assertThat(GameStatus.find(description)).isEqualByComparingTo(gameStatus);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2", "3", "가", "a", ""})
    void 유효하지_않은_번호를_입력하면_에러를_반환한다(String description) {
        assertThatThrownBy(() -> GameStatus.find(description))
                .isInstanceOf(InvalidGameStatusException.class)
                .hasMessage("1(시작) 또는 9(종료)를 눌러주세요.");
    }

}