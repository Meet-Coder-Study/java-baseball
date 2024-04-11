package baseball.generator;

import baseball.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BaseBallNumberShuffleGenerator implements BaseBallNumberGenerator {
    private static final Set<Number> numbers = Set.of(
            new Number(1),
            new Number(2),
            new Number(3),
            new Number(4),
            new Number(5),
            new Number(6),
            new Number(7),
            new Number(8),
            new Number(9)
    );
    private static final int TOTAL_SIZE = 3;

    @Override
    public List<Number> generate() {
        List<Number> pickNumbers = new ArrayList<>(numbers);

        Collections.shuffle(pickNumbers);

        return pickNumbers.subList(0, TOTAL_SIZE);
    }
}
