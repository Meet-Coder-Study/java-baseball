package org.example.application.service;

import static org.example.domain.AnswerNumber.LENGTH;

import org.example.application.port.in.ResultUsecase;
import org.example.domain.AnswerNumber;
import org.example.domain.InputNumber;
import org.example.domain.Result;

public class ResultService implements ResultUsecase {

    @Override
    public Result check(final AnswerNumber answerNumber, final InputNumber inputNumber) {
        Result result = new Result();
        for (int i = 0; i < LENGTH; i++) {
            result = checkNumber(result, answerNumber, inputNumber, i);
        }
        return result;
    }

    private Result checkNumber(
        final Result result,
        final AnswerNumber answerNumber,
        final InputNumber inputNumber,
        final int index
    ) {
        if (Result.isBall(answerNumber, inputNumber, index)) {
            return result.updateBall();
        }
        if (Result.isStrike(answerNumber, inputNumber, index)) {
            return result.updateStrike();
        }
        return result;
    }
}
