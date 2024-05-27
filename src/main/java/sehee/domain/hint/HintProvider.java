package sehee.domain.hint;

import static sehee.domain.answer.AnswerConstant.RANDOM_NUMBER_LENGTH;

import sehee.domain.answer.Answer;

public class HintProvider {

    public Hint getHintFrom(Answer answer, Answer userAnswer) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < RANDOM_NUMBER_LENGTH; i++) {
            for (int j = 0; j < RANDOM_NUMBER_LENGTH; j++) {
                if (answer.numbers()[i] == userAnswer.numbers()[j]) {
                    if (i == j) {
                        strikeCnt++;
                        continue;
                    }

                    ballCnt++;
                }
            }
        }

        return new Hint(strikeCnt, ballCnt);
    }

}
