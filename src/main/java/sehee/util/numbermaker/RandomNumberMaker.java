package sehee.util.numbermaker;

import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;

import java.util.Random;

// package-private
public class RandomNumberMaker implements NumberMaker {

    private final Random random;

    public RandomNumberMaker(Random random) {
        this.random = random;
    }

    public int make() {
        return random.nextInt(9) + 1;
    }

    public int[] makeAllUnique() {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;

        int[] randomNumbers = new int[ANSWER_LENGTH];
        int count = 0;
        while (count < randomNumbers.length) {
            count = makeAndCountUnique(isExist, randomNumbers, count);
        }

        return randomNumbers;
    }

    private int makeAndCountUnique(boolean[] isExist, int[] randomNumbers, int count) {
        int randomNumber = this.make(); // 1~9
        if (!isExist[randomNumber]) { // 모두 다른 숫자
            isExist[randomNumber] = true;
            randomNumbers[count++] = randomNumber;
        }

        return count;
    }

}
