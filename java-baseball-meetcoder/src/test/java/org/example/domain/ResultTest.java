package org.example.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    public void 볼과_스트라이크가_모두_0일때_낫싱이다() {
        // given
        int ball = 0;
        int strike = 0;
        Result result = new Result(ball, strike);

        // when
        boolean isNothing = result.isNothing();

        // then
        assertTrue(isNothing);
    }

    @Test
    public void 스트라이크가_3일때_쓰리스트라이크이다() {
        // given
        int ball = 0;
        int strike = 3;
        Result result = new Result(ball, strike);

        // when
        boolean isThreeStrike = result.isThreeStrike();

        // then
        assertTrue(isThreeStrike);
    }

    @Test
    public void 볼_카운트를_증가할_수_있다() {
        // given
        int ball = 0;
        int strike = 0;
        Result result = new Result(ball, strike);

        // when
        Result newResult = result.updateBall();

        // then
        int updateBall = ball + 1;
        assertEquals(newResult.ball, updateBall);
    }

    @Test
    public void 스트라이크_카운트를_증가할_수_있다() {
        // given
        int ball = 0;
        int strike = 0;
        Result result = new Result(ball, strike);

        // when
        Result newResult = result.updateStrike();

        //then
        int updateStrike = strike + 1;
        assertEquals(newResult.strike, updateStrike);
    }

    @Test
    public void 다른_위치에_같은_수가_있다면_볼로_판정할_수_있다() {
        // given
        List<Integer> computerValues = List.of(1, 2, 3);
        List<Integer> userValues = List.of(2, 5, 6);
        AnswerNumber answerNumber = new AnswerNumber(computerValues);
        InputNumber inputNumber = new InputNumber(userValues);
        int index = 0;

        // when
        boolean isBall = Result.isBall(answerNumber, inputNumber, index);

        //then
        assertTrue(isBall);
    }

    @Test
    public void 같은_위치에_같은_수가_있다면_스트라이크로_판정할_수_있다() {
        // given
        List<Integer> computerValues = List.of(1, 2, 3);
        List<Integer> userValues = List.of(1, 5, 6);
        AnswerNumber answerNumber = new AnswerNumber(computerValues);
        InputNumber inputNumber = new InputNumber(userValues);
        int index = 0;

        // when
        boolean isStrike = Result.isStrike(answerNumber, inputNumber, index);

        //then
        assertTrue(isStrike);
    }

}
