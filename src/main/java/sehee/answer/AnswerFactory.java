package sehee.answer;

import sehee.util.numbermaker.NumberMaker;

public class AnswerFactory {

    private final NumberMaker numberMaker;

    public AnswerFactory(NumberMaker numberMaker) {
        this.numberMaker = numberMaker;
    }

    public Answer make() {
        int[] numbers = numberMaker.makeAllUnique();

        return new Answer(numbers);
    }

    public Answer make(int[] numbers) {
        AnswerNumberValidator.check(numbers);

        return new Answer(numbers);
    }

}
