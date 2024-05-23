package baseball.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Command {
    START("1"),
    END("9");

    private static final Map<Integer, Command> COMMEND_VALUES = Arrays.stream(values())
            .collect(Collectors.toMap(command -> Integer.parseInt(command.value), Function.identity()));

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    public static Command of(final int value) {
        return Optional.ofNullable(COMMEND_VALUES.get(value))
                .orElseThrow(() -> new IllegalArgumentException("1 또는 9만 입력 가능합니다."));
    }
}
