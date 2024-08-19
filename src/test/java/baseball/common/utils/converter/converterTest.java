package baseball.common.utilsr;

import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.common.utils.converter.intToDigits;
import static org.assertj.core.api.Assertions.assertThat;

class converterTest {


    @Test
    void int타입의_숫자를_한자리씩_리스트로_변환한다() {
        // given
        int input = 123;
        List<Integer> expected = List.of(1, 2, 3);

        // when
        List<Integer> actual = intToDigits(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}