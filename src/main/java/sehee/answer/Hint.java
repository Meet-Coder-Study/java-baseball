package sehee.answer;

import static sehee.util.constant.NumberBaseballGameConstant.BALL;
import static sehee.util.constant.NumberBaseballGameConstant.NOTHING;
import static sehee.util.constant.NumberBaseballGameConstant.STRIKE;

public class Hint {

    private int ballCount;
    private int strikeCount;

    // package-private
    Hint() {
        ballCount = 0;
        strikeCount = 0;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        StringBuilder hintStringBuilder = new StringBuilder();

        if (ballCount != 0) {
            hintStringBuilder.append(ballCount)
                .append(BALL);
        }

        if (strikeCount != 0) {
            if (ballCount != 0) {
                hintStringBuilder.append(" ");
            }

            hintStringBuilder.append(strikeCount)
                .append(STRIKE);
        }

        return hintStringBuilder.toString();
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    void increaseBallCount() {
        this.ballCount++;
    }

    void increaseStrikeCount() {
        this.strikeCount++;
    }

}
