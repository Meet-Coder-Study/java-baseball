package sehee.answer;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

// package-private
final class Validator {

    static void checkAllDuplicated(int[] userInputs) {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        for (int number : userInputs) {
            checkDuplicated(number, isExist);
        }
    }

    static void checkDuplicated(int number, boolean[] isExist) {
        if (isExist[number]) {
            throw new IllegalArgumentException("1~9 사이의 모두 다른 숫자여야합니다.");
        }

        isExist[number] = true;
    }

    static void checkLength(int[] userInputs) {
        if (userInputs.length != ANSWER_LENGTH) {
            throw new IllegalArgumentException(ANSWER_LENGTH + "자의 숫자로 입력해주세요.");
        }
    }

}
