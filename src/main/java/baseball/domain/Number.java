package baseball.domain;

import java.util.Objects;

public class Number {
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final int value;

    public Number(int value) {
        validateRange(value);
        this.value = value;
    }

    public void validateRange(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return value == number.value;
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
