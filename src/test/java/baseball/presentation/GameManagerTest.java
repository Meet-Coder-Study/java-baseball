package baseball.presentation;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.presentation.input.InputProvider;
import org.junit.jupiter.api.Test;
import java.util.List;


class GameManagerTest {

    @Test
    void 게임시작_입력값이_1이면_START를_반환한다() {
        // given
        MessagePrinter messagePrinter = new MessagePrinter();
        InputProvider inputProvider = () -> "1";
        GameManager gameManager = new GameManager(messagePrinter, inputProvider);

        // when
        GameStatus actual = gameManager.init();

        // then
        assertThat(actual).isEqualTo(GameStatus.START);
    }

    @Test
    void 게임시작_입력값이_9이면_QUIT를_반환한다() {
        // given
        MessagePrinter messagePrinter = new MessagePrinter();
        InputProvider inputProvider = () -> "9";
        GameManager gameManager = new GameManager(messagePrinter, inputProvider);

        // when
        GameStatus actual = gameManager.init();

        // then
        assertThat(actual).isEqualTo(GameStatus.QUIT);
    }

    @Test
    void 숫자입력_입력값이_올바르면_길이가_3이고_중복없는_리스트를_반환한다() {
        // given
        MessagePrinter messagePrinter = new MessagePrinter();
        InputProvider inputProvider = () -> "123";
        GameManager gameManager = new GameManager(messagePrinter, inputProvider);
        List<Integer> expected = List.of(1, 2, 3);

        // when
        List<Integer> actual = gameManager.getUserDigits();

        // then
        assertThat(actual).isEqualTo(expected);
        assertThat(actual.size()).isEqualTo(expected.size());
        assertThat(actual).doesNotHaveDuplicates();
    }
}