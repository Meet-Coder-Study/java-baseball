package baseball.domain;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class BaseBallNumbers implements Iterable<Number> {
    public static final int TOTAL_COUNT = 3;

    private final List<Number> numbers;

    public BaseBallNumbers(List<Number> numbers) {
        this.numbers = numbers;
        validateDuplicateNumbers();
        validateSize();
    }

    public boolean isContains(Number number) {
        return numbers.contains(number);
    }

    public boolean isSameIndexOf(Number number, int index) {
        return numbers.get(index).equals(number);
    }

    public int indexOf(Number number) {
        return numbers.indexOf(number);
    }

    private boolean isTotalSize() {
        return this.numbers.size() == TOTAL_COUNT;
    }

    private boolean isDuplication() {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateDuplicateNumbers() {
        if (isDuplication()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private void validateSize() {
        if (!isTotalSize()) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseBallNumbers that = (BaseBallNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public Iterator<Number> iterator() {
        return numbers.iterator();
    }
}
