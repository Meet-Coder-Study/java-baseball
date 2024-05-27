package sehee.domain.answer;

import static sehee.domain.answer.AnswerConstant.RANDOM_NUMBER_LENGTH;

import java.util.Random;

public class AnswerFactory {

    private final Random random;

    public AnswerFactory() {
        random = new Random();
    }

    public Answer makeRandomAnswer() {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;

        int[] randomNumbers = new int[RANDOM_NUMBER_LENGTH];
        int count = 0;

        while (count < randomNumbers.length) {
            int randomNumber = random.nextInt(9) + 1; // 1~9
            if (!isExist[randomNumber]) { // 모두 다른 숫자
                isExist[randomNumber] = true;
                randomNumbers[count++] = randomNumber;
            }
        }

        return new Answer(randomNumbers);
    }

    public Answer makeUserAnswer(int[] userInputs) {
        checkUserInput(userInputs);
        boolean[] isExist = new boolean[10];
        isExist[0] = true;

        for (int number : userInputs) {
            checkIsExistNumber(number, isExist);
        }

        return new Answer(userInputs);
    }

    private void checkIsExistNumber(int number, boolean[] isExist) {
        if (isExist[number]) {
            throw new IllegalArgumentException("1~9 사이의 모두 다른 숫자여야합니다.");
        }

        isExist[number] = true;
    }

    private void checkUserInput(int[] userInputs) {
        if (userInputs.length > RANDOM_NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자는 " + RANDOM_NUMBER_LENGTH + "자 이하여야합니다.");
        }
    }

}
