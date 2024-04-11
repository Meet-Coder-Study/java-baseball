package baseball.domain;

import java.util.List;

public class Computer {
    private final BaseBallNumbers numbers;

    public Computer(List<Number> numbers) {
        this.numbers = new BaseBallNumbers(numbers);
    }

    public boolean isBall(Number number) {
        return numbers.isContains(number);
    }

    public boolean isStrike(Number number, int index) {
        return numbers.isSameIndexOf(number, index);
    }

    public boolean isSameNumbers(BaseBallNumbers numbers) {
        return this.numbers.equals(numbers);
    }
}
