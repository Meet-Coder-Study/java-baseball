package org.example.client;

import java.util.List;

public class BaseBallCounter {

    public BallStrikeCount checkCount(List<Integer> gameControlNumber, List<Integer> clientNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (gameControlNumber.get(i).equals(clientNumber.get(i))) {
                strikeCount++;
                continue;
            }

            if (gameControlNumber.contains(clientNumber.get(i))) {
                ballCount++;
            }
        }

        return new BallStrikeCount(strikeCount, ballCount);
    }

}
