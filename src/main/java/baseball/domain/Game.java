package baseball.domain;

import java.util.List;

public class Game {
    private final BaseBallNumbers computerNumbers;

    public Game(List<Number> numbers) {
        this.computerNumbers = new BaseBallNumbers(numbers);
    }

    public boolean isBall(Number number) {
        return computerNumbers.isContains(number);
    }

    public boolean isStrike(Number number, int index) {
        return computerNumbers.isSameIndexOf(number, index);
    }

    public boolean isSameNumbers(BaseBallNumbers numbers) {
        return this.computerNumbers.equals(numbers);
    }
}
