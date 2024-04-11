package baseball.generator;

import baseball.domain.Number;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseBallNumberRandomIndexGenerator implements BaseBallNumberGenerator {
    private static final Random random = new Random();
    private static final List<Number> numbers = List.of(
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
        Set<Number> pickNumbers = new HashSet<>();

        while (pickNumbers.size() < TOTAL_SIZE) {
            int randomIndex = random.nextInt(numbers.size());
            Number pickNumber = numbers.get(randomIndex);

            pickNumbers.add(pickNumber);
        }

        return pickNumbers.stream()
                .toList();
    }
}
