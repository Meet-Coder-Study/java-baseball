package meetcoder.study.model;

import static meetcoder.study.util.Validator.checkArgument;

import java.util.Objects;

public class BallNumber {

  public static final int MIN_BALL_NUMBER = 1;
  public static final int MAX_BALL_NUMBER = 9;
  private final int number;

  private BallNumber(int number) {
    this.number = number;
  }

  public static BallNumber of(int number) {
    checkArgument(
        number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER,
        "BallNumber은 " + MIN_BALL_NUMBER + "~" + MAX_BALL_NUMBER + "사이의 숫자여야 합니다."
    );
    return new BallNumber(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BallNumber that = (BallNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

}
