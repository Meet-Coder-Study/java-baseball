package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommendTest {
    private static Stream<Arguments> provideOfTestFixtures() {
        return Stream.of(
                Arguments.of(1, Commend.START),
                Arguments.of(9, Commend.END)
        );
    }

    @DisplayName("명령어 찾기 테스트")
    @ParameterizedTest
    @MethodSource("provideOfTestFixtures")
    void ofTest(int value, Commend expected) {
        Commend actual = Commend.of(value);

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("존재하지 않는 명령어를 입력하면 예외가 발생한다.")
    @Test
    void ofExceptionTest() {
        assertThatThrownBy(() -> Commend.of(2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 9만 입력 가능합니다.");
    }
}
