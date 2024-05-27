package sehee.domain.hint;

public record Hint(
    int strikeCount,
    int ballCount
) {

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
