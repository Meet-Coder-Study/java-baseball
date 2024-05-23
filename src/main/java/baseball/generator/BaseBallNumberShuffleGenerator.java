package baseball.generator;

import baseball.domain.BaseBallNumbers;
import baseball.domain.Number;
import baseball.factory.BaseBallNumberFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseBallNumberShuffleGenerator implements BaseBallNumberGenerator {

    @Override
    public List<Number> generate() {
        final List<Number> numbers = BaseBallNumberFactory.getNumbers();
        final List<Number> pickNumbers = new ArrayList<>(numbers);

        Collections.shuffle(pickNumbers);

        return pickNumbers.subList(0, BaseBallNumbers.TOTAL_COUNT);
    }
}
