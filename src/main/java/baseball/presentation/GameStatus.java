package baseball.presentation;

import baseball.exception.InvalidGameStatusException;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameStatus {

    START("1"),
    QUIT("9");

    private final String description;
    private static final Map<String, GameStatus> descriptions =
            Collections.unmodifiableMap(Stream.of(GameStatus.values())
                    .collect(Collectors.toMap(GameStatus::getDescription, Function.identity())));

    GameStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static GameStatus find(String description) throws InvalidGameStatusException {
        return Optional.ofNullable(descriptions.get(description)).orElseThrow(
                () -> new InvalidGameStatusException("1(시작) 또는 9(종료)를 눌러주세요.")
        );
    }
}
