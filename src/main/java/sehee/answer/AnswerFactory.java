package sehee.answer;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

import sehee.util.numbermaker.NumberMaker;

public record AnswerFactory(
    NumberMaker numberMaker
) {

    public Answer make() {
        int[] numbers = numberMaker.makeAllUnique();

        return new Answer(numbers);
    }

    public Answer make(int[] numbers) {
        AnswerNumberValidator.check(numbers);

        return new Answer(numbers);
    }

}
