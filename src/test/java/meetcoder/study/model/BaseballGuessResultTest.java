package meetcoder.study.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballGuessResultTest {

    @DisplayName("스트라이크 수가 3개인 경우, isAllStrike가 true이다.")
    @Test
    void shouldReturnTrueWhenAllThreeAreStrikes() {
        // when
        BaseballGuessResult result = new BaseballGuessResult(3, 0);

        // then
        assertTrue(result.isAllStrike());
    }

    @DisplayName("추측 결과를 요약한다.")
    @Test
    void shouldSummarizeGuessResultCorrectly() {
        // when
        BaseballGuessResult result = new BaseballGuessResult(1, 2);

        // then
        assertEquals(result.summary(), "2볼 1스트라이크");
    }

}
