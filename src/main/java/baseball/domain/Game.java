package baseball.domain;

import java.util.List;

public class Game {
    private final BaseBallNumbers computerNumbers;

    public Game(final List<Number> numbers) {
        this.computerNumbers = new BaseBallNumbers(numbers);
    }

    public boolean isBall(final Number number, final int index) {
        return computerNumbers.isContains(number) && !isStrike(number, index);
    }

    public boolean isStrike(final Number number, final int index) {
        return computerNumbers.isSameIndexOf(number, index);
    }

    public boolean isSameNumbers(final BaseBallNumbers numbers) {
        return this.computerNumbers.equals(numbers);
    }
}
