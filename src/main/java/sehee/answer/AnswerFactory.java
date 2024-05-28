package sehee.answer;

import static sehee.util.constant.RandomNumberGameConstant.ANSWER_LENGTH;

public record AnswerFactory(
    NumberMaker numberMaker
) {

    public Answer make() {
        int[] randomNumbers = numberMaker.makeAllUniqueRandom(ANSWER_LENGTH);

        return new Answer(randomNumbers);
    }

    public Answer make(int[] userInputs) {
        Validator.checkLength(userInputs);
        Validator.checkAllDuplicated(userInputs);

        return new Answer(userInputs);
    }

}
