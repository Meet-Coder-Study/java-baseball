package meetcoder.study.model;

import static meetcoder.study.model.BallNumber.MAX_BALL_NUMBER;
import static meetcoder.study.model.BallNumber.MIN_BALL_NUMBER;
import static meetcoder.study.util.Validator.checkArgument;

import java.util.List;
import java.util.Objects;

public class BallNumbers {

  public static final int BALL_NUMBERS_SIZE = 3;
  private final List<BallNumber> numbers;

  private BallNumbers(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers.stream()
        .map(BallNumber::of)
        .toList();
  }

  public static BallNumbers of(List<Integer> numbers) {
    return new BallNumbers(numbers);
  }

  public BaseballGuessResult evaluateGuess(BallNumbers guessedNumber) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < BALL_NUMBERS_SIZE; i++) {
      GuessResultType result = evaluateSingleGuess(guessedNumber.numbers.get(i), i);
      if (Objects.equals(result, GuessResultType.STRIKE)) {
        strike++;
      } else if (Objects.equals(result, GuessResultType.BALL)) {
        ball++;
      }
    }

    return new BaseballGuessResult(strike, ball);
  }

  public GuessResultType evaluateSingleGuess(BallNumber number, int position) {
    if (isStrike(number, position)) {
      return GuessResultType.STRIKE;
    }

    if (isBall(number, position)) {
      return GuessResultType.BALL;
    }

    return GuessResultType.NOTHING;
  }

  private boolean isStrike(BallNumber number, int position) {
    return position < BALL_NUMBERS_SIZE && numbers.get(position)
        .equals(number);
  }

  private boolean isBall(BallNumber number, int position) {
    return !isStrike(number, position) && numbers.contains(number);
  }

  private void validate(List<Integer> numbers) {
    long count = numbers.stream()
        .distinct()
        .count();

    checkArgument(
        count == BALL_NUMBERS_SIZE,
        "야구 숫자는 " + MIN_BALL_NUMBER + "~" + MAX_BALL_NUMBER + "사이의 서로 다른 " + BALL_NUMBERS_SIZE
            + "자리 숫자여야 합니다."
    );
  }

}
