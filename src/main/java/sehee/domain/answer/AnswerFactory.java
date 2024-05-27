package sehee.domain.answer;

import static sehee.domain.answer.AnswerConstant.RANDOM_NUMBER_LENGTH;

import sehee.util.NumberMaker;

public record AnswerFactory(
    NumberMaker numberMaker
) {

    public Answer makeRandomAnswer() {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        int[] randomNumbers = makeRandomNumbers(isExist);

        return new Answer(randomNumbers);
    }

    public Answer makeUserAnswer(int[] userInputs) {
        checkNumberLength(userInputs);
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        checkDuplicatedNumbers(userInputs, isExist);

        return new Answer(userInputs);
    }

    private int[] makeRandomNumbers(boolean[] isExist) {
        int[] randomNumbers = new int[RANDOM_NUMBER_LENGTH];
        int count = 0;
        while (count < randomNumbers.length) {
            count = makeUniqueRandomNumber(isExist, randomNumbers, count);
        }

        return randomNumbers;
    }

    private int makeUniqueRandomNumber(boolean[] isExist, int[] randomNumbers, int count) {
        int randomNumber = numberMaker.makeOneRandomNumber(); // 1~9
        if (!isExist[randomNumber]) { // 모두 다른 숫자
            isExist[randomNumber] = true;
            randomNumbers[count++] = randomNumber;
        }

        return count;
    }

    private void checkDuplicatedNumbers(int[] userInputs, boolean[] isExist) {
        for (int number : userInputs) {
            checkDuplicatedNumber(number, isExist);
        }
    }

    private void checkDuplicatedNumber(int number, boolean[] isExist) {
        if (isExist[number]) {
            throw new IllegalArgumentException("1~9 사이의 모두 다른 숫자여야합니다.");
        }

        isExist[number] = true;
    }

    private void checkNumberLength(int[] userInputs) {
        if (userInputs.length != RANDOM_NUMBER_LENGTH) {
            throw new IllegalArgumentException(RANDOM_NUMBER_LENGTH + "자의 숫자로 입력해주세요.");
        }
    }

}
