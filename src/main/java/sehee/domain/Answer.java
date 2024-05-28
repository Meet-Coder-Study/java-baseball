package sehee.domain;

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
            matchInAnswer(i, otherAnswer, hint);
        }

        return hint;
    }

    private void matchInAnswer(int index, Answer otherAnswer, Hint hint) {
        for (int j = 0; j < ANSWER_LENGTH; j++) {
            matchNumberWithIndex(index, otherAnswer.numbers[j], j, hint);
        }
    }

    private void matchNumberWithIndex(int index, int otherAnswerNumber, int otherAnswerIndex, Hint hint) {
        if (this.numbers[index] == otherAnswerNumber) {
            if (index == otherAnswerIndex) {
                hint.increaseStrikeCount();
                return;
            }

            hint.increaseBallCount();
        }
    }
}
