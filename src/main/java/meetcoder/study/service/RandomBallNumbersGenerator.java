package meetcoder.study.service;

import static meetcoder.study.model.BallNumber.MAX_BALL_NUMBER;
import static meetcoder.study.model.BallNumber.MIN_BALL_NUMBER;
import static meetcoder.study.model.BallNumbers.BALL_NUMBERS_SIZE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import meetcoder.study.model.BallNumbers;

public class RandomBallNumbersGenerator implements BallNumbersGenerator {

  @Override
  public BallNumbers generate() {
    List<Integer> numbers = createNumberRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER);
    Collections.shuffle(numbers);

    return BallNumbers.of(
        new ArrayList<>(numbers.subList(0, BALL_NUMBERS_SIZE)));
  }

  private List<Integer> createNumberRange(int min, int max) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = min; i <= max; i++) {
      numbers.add(i);
    }

    return numbers;
  }

}
