package sehee.answer;

import java.util.Random;

// package-private
public class NumberMaker {

    private final Random random;

    public NumberMaker(Random random) {
        this.random = random;
    }

    int makeRandomOne() {
        return random.nextInt(9) + 1;
    }

    int[] makeAllUniqueRandom(int length) {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;

        int[] randomNumbers = new int[length];
        int count = 0;
        while (count < randomNumbers.length) {
            count = makeAndCountUniqueRandom(isExist, randomNumbers, count);
        }

        return randomNumbers;
    }

    int makeAndCountUniqueRandom(boolean[] isExist, int[] randomNumbers, int count) {
        int randomNumber = makeRandomOne(); // 1~9
        if (!isExist[randomNumber]) { // 모두 다른 숫자
            isExist[randomNumber] = true;
            randomNumbers[count++] = randomNumber;
        }

        return count;
    }

}
