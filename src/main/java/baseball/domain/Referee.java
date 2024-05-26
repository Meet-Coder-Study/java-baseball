package baseball.domain;

import java.util.List;

public class Referee {

    private static final String BALL_CALL = "볼";
    private static final String STRIKE_CALL = "스트라이크";
    private static final String NOTHING_CALL = "낫싱";
    private static final String SPACE_CHARACTER = " ";
    private static final int INIT_COUNT = 0;
    private static final int OUT_COUNT = 3;

    private int ball = INIT_COUNT;
    private int strike = INIT_COUNT;
    private List<Integer> computerDigits;

    public void keepComputerDigits(List<Integer> computerDigits) {
        this.computerDigits = computerDigits;
    }

    public boolean judge(List<Integer> userDigits) {
        resetCounts();
        compareDigits(userDigits);

        return isOut();
    }

    public String getCallMessage() {
        String call = generateCallString();
        if (call.isEmpty()) {
            call = NOTHING_CALL;
        }
        return call;
    }

    private void resetCounts() {
        ball = INIT_COUNT;
        strike = INIT_COUNT;
    }

    private void compareDigits(List<Integer> userDigits) {
        for (int index = 0; index < computerDigits.size(); index++) {
            countBallOrStrike(userDigits, index);
        }
    }

    private void countBallOrStrike(List<Integer> userDigits, int index) {
        Integer userDigit = userDigits.get(index);
        Integer computerDigit = computerDigits.get(index);
        if (userDigit.equals(computerDigit)) {
            strike++;
        } else if (computerDigits.contains(userDigit)) {
            ball++;
        }
    }

    private boolean isOut() {
        return strike == OUT_COUNT;
    }

    private String generateCallString() {
        StringBuilder call = new StringBuilder();
        if (ball != INIT_COUNT) {
            call.append(ball)
                    .append(BALL_CALL)
                    .append(SPACE_CHARACTER);
        }

        if (strike != INIT_COUNT) {
            call.append(strike)
                    .append(STRIKE_CALL);
        }

        return call.toString().trim();
    }
}
