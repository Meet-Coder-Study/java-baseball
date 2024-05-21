package baseball.factory;

import baseball.domain.Number;

import java.util.List;
import java.util.stream.IntStream;

public class BaseBallNumberFactory {
    private static final List<Number> numbers = IntStream.rangeClosed(Number.MIN_VALUE, Number.MAX_VALUE)
            .mapToObj(Number::new)
            .toList();

    private BaseBallNumberFactory() {
    }

    public static Number valueOf(final int value) {
        return numbers.stream()
                .filter(number -> number.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다."));
    }

    public static Number valueOfIndex(final int index) {
        return numbers.get(index);
    }

    public static List<Number> getNumbers() {
        return numbers;
    }
}
