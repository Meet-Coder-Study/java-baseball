package org.example.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.example.factory.NumberFactory;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @Test
    public void 정답을_생성할_수_있다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2, 3);

        // when
        Answer answer = new Answer(values);

        // then
        assertEquals(answer.values, values);
    }

    @Test
    public void null로_정답을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = null;

        // when
        // then
        assertThatThrownBy(() -> new Answer(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 세자리_자리수가_아닌_수로_정답을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2);

        // when
        // then
        assertThatThrownBy(() -> new Answer(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복값으로_정답을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2, 2);

        // when
        // then
        assertThatThrownBy(() -> new Answer(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
