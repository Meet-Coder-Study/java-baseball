package sehee.answer;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

import sehee.util.numbermaker.NumberMaker;

public record AnswerFactory(
    NumberMaker numberMaker
) {

    public Answer make() {
        int[] numbers = numberMaker.makeAllUnique(ANSWER_LENGTH);

        return new Answer(numbers);
    }

    public Answer make(int[] numbers) {
        AnswerNumberValidator.check(numbers, ANSWER_LENGTH);

        return new Answer(numbers);
    }

}
