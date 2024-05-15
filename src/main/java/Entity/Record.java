package Entity;

import Enums.Game;

public class Record {

    public static final int HOME_RUN = 3;

    private final int strike;
    private final int ball;
    private final boolean isEnd;

    public Record(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        this.isEnd = strike == HOME_RUN;
    }

    public Game getResult() {
        return isEnd ? Game.END : Game.CONTINUE;
    }

    public void printResult() {
        StringBuilder sb = new StringBuilder();

        if(ball != 0) {
            sb.append(ball + "볼 ");
        }

        if(strike != 0) {
            sb.append(strike + "스트라이크");
        }

        if(ball == 0 && strike == 0) {
            sb.append("NOTHING");
        }

        System.out.println(sb);
    }
}