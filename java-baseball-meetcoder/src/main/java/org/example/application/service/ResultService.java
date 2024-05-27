package org.example.application.service;

import static org.example.domain.Answer.LENGTH;

import org.example.application.port.in.ResultUsecase;
import org.example.domain.Answer;
import org.example.domain.UserInput;
import org.example.domain.Result;

public class ResultService implements ResultUsecase {

    @Override
    public Result check(final Answer answer, final UserInput userInput) {
        Result result = new Result();
        for (int i = 0; i < LENGTH; i++) {
            result = checkNumber(result, answer, userInput, i);
        }
        return result;
    }

    private Result checkNumber(
        final Result result,
        final Answer answer,
        final UserInput userInput,
        final int index
    ) {
        if (Result.isBall(answer, userInput, index)) {
            return result.updateBall();
        }
        if (Result.isStrike(answer, userInput, index)) {
            return result.updateStrike();
        }
        return result;
    }
}
