package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    void 컴퓨터와_유저의_숫자가_모두_같을때_참이다() {
        // given
        List<Integer> computerDigits = List.of(1, 2, 3);
        List<Integer> userDigits = List.of(1, 2, 3);

        Referee referee = new Referee();
        referee.keepComputerDigits(computerDigits);

        // when
        boolean result = referee.judge(userDigits);

        // then
        assertThat(result).isTrue();
    }

    @Test
    void 컴퓨터와_유저의_숫자가_하나라도_다르면_거짓이다() {
        // given
        List<Integer> computerDigits = List.of(1, 2, 3);
        List<Integer> userDigits = List.of(1, 2, 4);

        Referee referee = new Referee();
        referee.keepComputerDigits(computerDigits);

        // when
        boolean result = referee.judge(userDigits);

        // then
        assertThat(result).isFalse();
    }

    @Test
    void 심판콜을_생성한다() {
        // given
        List<Integer> computerDigits = List.of(1, 2, 3);
        List<Integer> userDigits = List.of(3, 2, 1);
        String message = "2볼 1스트라이크";

        Referee referee = new Referee();
        referee.keepComputerDigits(computerDigits);

        // when
        referee.judge(userDigits);
        String callMessage = referee.getCallMessage();

        // then
        assertThat(callMessage).isEqualTo(message);
    }

    @Test
    void 낫싱_심판콜을_생성한다() {
        // given
        List<Integer> computerDigits = List.of(1, 2, 3);
        List<Integer> userDigits = List.of(4, 5, 6);
        String message = "낫싱";

        Referee referee = new Referee();
        referee.keepComputerDigits(computerDigits);

        // when
        referee.judge(userDigits);
        String callMessage = referee.getCallMessage();

        // then
        assertThat(callMessage).isEqualTo(message);
    }
}