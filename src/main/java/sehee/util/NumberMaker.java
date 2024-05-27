package sehee.util;

import java.util.Random;

public record NumberMaker(
    Random random
) {

    public int makeOneRandomNumber() {
        return random.nextInt(9) + 1;
    }

}
