package meetcoder.study.model;

import static meetcoder.study.model.BallNumbers.BALL_NUMBERS_SIZE;
import static meetcoder.study.model.GuessResultType.BALL;
import static meetcoder.study.model.GuessResultType.NOTHING;
import static meetcoder.study.model.GuessResultType.STRIKE;

public record BaseballGuessResult(
    int strikeCount,
    int ballCount
) {

  public boolean isAllStrike() {
    return strikeCount == BALL_NUMBERS_SIZE;
  }

  public String summary() {
    if (isNothing()) {
      return NOTHING.getName();
    }

    StringBuilder sb = new StringBuilder();
    if (hasBall()) {
      sb.append(ballCount)
          .append(BALL.getName())
          .append(" ");
    }

    if (hasStrike()) {
      sb.append(strikeCount)
          .append(STRIKE.getName());
    }

    return sb.toString()
        .trim();
  }

  private boolean isNothing() {
    return strikeCount == 0 && ballCount == 0;
  }

  private boolean hasStrike() {
    return strikeCount > 0;
  }

  private boolean hasBall() {
    return ballCount > 0;
  }

}
