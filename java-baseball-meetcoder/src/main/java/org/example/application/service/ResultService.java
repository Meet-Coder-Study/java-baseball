package org.example.application.service;

import static org.example.domain.Answer.LENGTH;

import org.example.application.port.in.ResultUsecase;
import org.example.domain.Answer;
import org.example.domain.InputNumber;
import org.example.domain.Result;

public class ResultService implements ResultUsecase {

    @Override
    public Result check(final Answer answer, final InputNumber inputNumber) {
        Result result = new Result();
        for (int i = 0; i < LENGTH; i++) {
            result = checkNumber(result, answer, inputNumber, i);
        }
        return result;
    }

    private Result checkNumber(
        final Result result,
        final Answer answer,
        final InputNumber inputNumber,
        final int index
    ) {
        if (result.isBall(answer, inputNumber, index)) {
            return result.updateBall();
        }
        if (result.isStrike(answer, inputNumber, index)) {
            return result.updateStrike();
        }
        return result;
    }
}
