package sehee.domain.hint;

import static sehee.domain.answer.AnswerConstant.RANDOM_NUMBER_LENGTH;

import sehee.domain.answer.Answer;

public record HintMaker(

) {

    public Hint make(Answer answer, Answer userAnswer) {
        Hint hint = new Hint();
        for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            countSameNumber(answer.numbers()[i], i, userAnswer, hint);
        }

        return hint;
    }

    private void countSameNumber(int answerNumber, int answerIndex, Answer userAnswer, Hint hint) {
        for (int j = 0; j < RANDOM_NUMBER_LENGTH; j++) {
            checkSameNumberAndIndex(answerNumber, answerIndex, userAnswer.numbers()[j], j, hint);
        }
    }

    private void checkSameNumberAndIndex(int answerNumber, int answerIndex, int userAnswerNumber, int userAnswerIndex,
                                         Hint hint) {
        if (answerNumber == userAnswerNumber) {
            if (answerIndex == userAnswerIndex) {
                hint.increaseStrikeCount();
                return;
            }

            hint.increaseBallCount();
        }
    }

}
