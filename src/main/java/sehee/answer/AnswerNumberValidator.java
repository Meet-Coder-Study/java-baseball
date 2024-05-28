package sehee.answer;

import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;
import static sehee.util.constant.NumberBaseballGameMessage.ANSWER_LENGTH_EXCEPTION_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.DUPLICATED_EXCEPTION_MESSAGE;

// package-private
final class AnswerNumberValidator {

    static void check(int[] numbers) {
        checkLength(numbers);
        checkAllUnique(numbers);
    }

    private static void checkLength(int[] numbers) {
        if (numbers.length != ANSWER_LENGTH) {
            throw new IllegalArgumentException(ANSWER_LENGTH_EXCEPTION_MESSAGE);
        }
    }

    private static void checkAllUnique(int[] numbers) {
        boolean[] isExist = new boolean[10];
        isExist[0] = true;
        for (int number : numbers) {
            checkUnique(number, isExist);
        }
    }

    private static void checkUnique(int number, boolean[] isExist) {
        if (isExist[number]) {
            throw new IllegalArgumentException(DUPLICATED_EXCEPTION_MESSAGE);
        }

        isExist[number] = true;
    }

}
