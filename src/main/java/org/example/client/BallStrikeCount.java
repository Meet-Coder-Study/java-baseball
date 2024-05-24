package org.example.client;

import org.example.message.GameMessage;

public record BallStrikeCount(
    int strikeCount,
    int ballCount
) {

    public void showBallStrikeCount() {
        if (strikeCount == 3) {
            System.out.println(GameMessage.THREE_STRIKE);
        }
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println(GameMessage.NO_CORRECT_NUM);
        }
        if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + GameMessage.BALL);
        }
        if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + GameMessage.STRIKE);
        }
        if (ballCount > 0 && strikeCount > 0) {
            System.out.println(ballCount + GameMessage.BALL + " " + strikeCount + GameMessage.STRIKE);
        }
    }

}
