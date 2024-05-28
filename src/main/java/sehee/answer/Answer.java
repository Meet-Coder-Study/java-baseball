package sehee.answer;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

public class Answer {

    private final int[] numbers;

    // package-private
    Answer(int[] numbers) {
        this.numbers = numbers;
    }

    public Hint match(Answer otherAnswer) {
        Hint hint = new Hint();
        for (int i = 0; i < ANSWER_LENGTH; i++) {
            this.matchInAnswer(i, otherAnswer, hint);
        }

        return hint;
    }

    private void matchInAnswer(int index, Answer otherAnswer, Hint hint) {
        for (int j = 0; j < ANSWER_LENGTH; j++) {
            this.matchNumberWithIndex(index, otherAnswer.numbers[j], j, hint);
        }
    }

    private void matchNumberWithIndex(int index, int otherNumber, int otherIndex, Hint hint) {
        if (this.numbers[index] == otherNumber) {
            if (index == otherIndex) {
                hint.increaseStrikeCount();
                return;
            }

            hint.increaseBallCount();
        }
    }
}
