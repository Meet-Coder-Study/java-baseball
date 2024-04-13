package baseball.generator;

import baseball.domain.Number;
import baseball.factory.BaseBallNumberFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BaseBallNumberRandomIndexGenerator implements BaseBallNumberGenerator {
    private static final Random random = new Random();
    private static final int TOTAL_SIZE = 3;

    @Override
    public List<Number> generate() {
        Set<Number> pickNumbers = new HashSet<>();

        while (pickNumbers.size() < TOTAL_SIZE) {
            int randomIndex = random.nextInt(Number.MAX_VALUE);
            Number pickNumber = BaseBallNumberFactory.valueOfIndex(randomIndex);

            pickNumbers.add(pickNumber);
        }

        return pickNumbers.stream()
                .toList();
    }
}
