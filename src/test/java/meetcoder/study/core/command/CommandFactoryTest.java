package meetcoder.study.core.command;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.HashMap;
import java.util.Map;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandFactoryTest {

    @DisplayName("유효한 키로 Command를 가져올 수 있다.")
    @Test
    void shouldReturnCommandForValidKey() {
        // given
        String key = "key";
        Command mockCommand = () -> {
        };
        CommandFactory commandFactory = new CommandFactory(Map.of(key, mockCommand));

        // when
        Command command = commandFactory.getCommand(key);

        // then
        assertThat(command).isEqualTo(mockCommand);
    }

    @DisplayName("존재하지 않는 키로 Command를를 가져오려고 하면 예외가 발생한다.")
    @Test
    void shouldThrowExceptionForInvalidKey() {
        // given
        CommandFactory commandFactory = new CommandFactory(new HashMap<>());

        // when
        ThrowingCallable getCommand = () -> commandFactory.getCommand("invalidKey");

        // when & then
        assertThatIllegalArgumentException()
            .isThrownBy(getCommand)
            .withMessage("존재하지 않는 명령어입니다.");
    }


}
