package sehee.domain.hint;

public class Hint {

    private int ballCount;
    private int strikeCount;

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

        String hintToStirng = "";

        if (ballCount != 0) {
            hintToStirng += ballCount + "볼 ";
        }

        if (strikeCount != 0) {
            hintToStirng += strikeCount + "스트라이크";
        }

        return hintToStirng;
    }

}
