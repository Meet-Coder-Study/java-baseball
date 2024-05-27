package org.example.domain;

import java.util.List;
import java.util.Objects;

public class Result {

    public final int ball;
    public final int strike;

    public static final int INIT_VALUE = 0;
    public static final int THREE_STRIKE = 3;

    public Result() {
        this.ball = INIT_VALUE;
        this.strike = INIT_VALUE;
    }

    public Result(final int ball, final int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isThreeStrike() {
        return this.strike == THREE_STRIKE;
    }

    public boolean isNothing() {
        return this.ball == INIT_VALUE && this.strike == INIT_VALUE;
    }

    public Result updateBall() {
        final int newBall = this.ball + 1;
        return new Result(newBall, this.strike);
    }

    public Result updateStrike() {
        final int newStrike = this.strike + 1;
        return new Result(this.ball, newStrike);
    }

    public static boolean isBall(
        final Answer answer,
        final UserInput userInput,
        final int index
    ) {
        final List<Number> computerValues = answer.values;
        final Number userNum = userInput.values.get(index);
        return !isStrike(answer, userInput, index) && computerValues.contains(userNum);
    }

    public static boolean isStrike(
        final Answer answer,
        final UserInput userInput,
        final int index
    ) {
        final Number computerNum = answer.values.get(index);
        final Number userNum = userInput.values.get(index);
        return Objects.equals(computerNum, userNum);
    }


}
