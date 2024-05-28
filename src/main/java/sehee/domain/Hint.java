package sehee.domain;

public class Hint {

    private int ballCount;
    private int strikeCount;

    // package-private
    Hint() {
        ballCount = 0;
        strikeCount = 0;
    }

    // package-private
    void increaseBallCount() {
        this.ballCount++;
    }

    void increaseStrikeCount() {
        this.strikeCount++;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    @Override
    public String toString() {
        if (ballCount == 0 && strikeCount == 0) {
            return "낫싱";
        }

        StringBuilder hintStringBuilder = new StringBuilder();

        if (ballCount != 0) {
            hintStringBuilder.append(ballCount)
                .append("볼 ");
        }

        if (strikeCount != 0) {
            hintStringBuilder.append(strikeCount)
                .append("스트라이크");
        }

        return hintStringBuilder.toString();
    }

}
