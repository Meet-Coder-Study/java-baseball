package sehee.answer;

// package-private
final class AnswerNumberValidator {

    static void check(int[] numbers, int length) {
        checkLength(numbers, length);
        checkAllUnique(numbers);
    }

    private static void checkLength(int[] numbers, int length) {
        if (numbers.length != length) {
            throw new IllegalArgumentException(length + "자의 숫자로 입력해주세요.");
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
            throw new IllegalArgumentException("1~9 사이의 모두 다른 숫자여야합니다.");
        }

        isExist[number] = true;
    }

}
