package org.example.application.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.domain.Answer;
import org.example.domain.Result;
import org.example.domain.UserInput;
import org.example.factory.AnswerFactory;
import org.example.factory.UserInputFactory;
import org.junit.jupiter.api.Test;

class ResultServiceTest {

    @Test
    void 일치하는_수가_없을_때_낫싱으로_판정한다() {
        // given
        ResultService resultService = new ResultService();
        Answer answer = AnswerFactory.createAnswer(1, 2, 3);
        UserInput userInput = UserInputFactory.createUserInput(6, 7, 8);

        // when
        Result result = resultService.check(answer, userInput);

        // then
        assertAll(
            () -> assertEquals(0, result.ball),
            () -> assertEquals(0, result.strike),
            () -> assertTrue(result.isNothing())
        );
    }

    @Test
    void 포함하는_수가_있을_때_볼로_판정한다() {
        // given
        ResultService resultService = new ResultService();
        Answer answer = AnswerFactory.createAnswer(1, 2, 3);
        UserInput userInput = UserInputFactory.createUserInput(6, 7, 1);

        // when
        Result result = resultService.check(answer, userInput);

        // then
        assertAll(
            () -> assertEquals(1, result.ball),
            () -> assertEquals(0, result.strike),
            () -> assertFalse(result.isNothing())
        );
    }

    @Test
    void 위치가_일치하는_수가_있을_때_스트라이크로_판정한다() {
        // given
        ResultService resultService = new ResultService();
        Answer answer = AnswerFactory.createAnswer(1, 2, 3);
        UserInput userInput = UserInputFactory.createUserInput(1, 6, 7);

        // when
        Result result = resultService.check(answer, userInput);

        // then
        assertAll(
            () -> assertEquals(0, result.ball),
            () -> assertEquals(1, result.strike),
            () -> assertFalse(result.isNothing())
        );
    }

    @Test
    void 볼과_스트라이크가_섞여있을_때_정상적으로_카운트_할_수_있다() {
        // given
        ResultService resultService = new ResultService();
        Answer answer = AnswerFactory.createAnswer(1, 2, 3);
        UserInput userInput = UserInputFactory.createUserInput(3, 2, 8);

        // when
        Result result = resultService.check(answer, userInput);

        // then
        assertAll(
            () -> assertEquals(1, result.ball),
            () -> assertEquals(1, result.strike),
            () -> assertFalse(result.isNothing())
        );
    }


}
