package baseball.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Commend {
    START("1"),
    END("9");

    private static final Map<Integer, Commend> COMMEND_VALUES = Arrays.stream(values())
            .collect(Collectors.toMap(commend -> Integer.parseInt(commend.value), Function.identity()));

    private final String value;

    Commend(String value) {
        this.value = value;
    }

    public static Commend of(int value) {
        return Optional.ofNullable(COMMEND_VALUES.get(value))
                .orElseThrow(() -> new IllegalArgumentException("1 또는 9만 입력 가능합니다."));
    }
}
