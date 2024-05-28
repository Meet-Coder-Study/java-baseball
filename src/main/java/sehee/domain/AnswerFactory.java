package sehee.domain;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

import sehee.util.NumberMaker;

public record AnswerFactory(
    NumberMaker numberMaker
) {

    public Answer make() {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        int[] randomNumbers = makeUniqueRandomNumbers(isExist);

        return new Answer(randomNumbers);
    }

    public Answer make(int[] userInputs) {
        checkLength(userInputs);
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        checkAllDuplicated(userInputs, isExist);

        return new Answer(userInputs);
    }

    private int[] makeUniqueRandomNumbers(boolean[] isExist) {
        int[] randomNumbers = new int[ANSWER_LENGTH];
        int count = 0;
        while (count < randomNumbers.length) {
            count = makeAndCountUniqueRandomNumber(isExist, randomNumbers, count);
        }

        return randomNumbers;
    }

    private int makeAndCountUniqueRandomNumber(boolean[] isExist, int[] randomNumbers, int count) {
        int randomNumber = numberMaker.makeRandomOne(); // 1~9
        if (!isExist[randomNumber]) { // 모두 다른 숫자
            isExist[randomNumber] = true;
            randomNumbers[count++] = randomNumber;
        }

        return count;
    }

    private void checkAllDuplicated(int[] userInputs, boolean[] isExist) {
        for (int number : userInputs) {
            checkDuplicated(number, isExist);
        }
    }

    private void checkDuplicated(int number, boolean[] isExist) {
        if (isExist[number]) {
            throw new IllegalArgumentException("1~9 사이의 모두 다른 숫자여야합니다.");
        }

        isExist[number] = true;
    }

    private void checkLength(int[] userInputs) {
        if (userInputs.length != ANSWER_LENGTH) {
            throw new IllegalArgumentException(ANSWER_LENGTH + "자의 숫자로 입력해주세요.");
        }
    }

}
