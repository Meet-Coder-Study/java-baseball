package org.example.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.example.factory.NumberFactory;
import org.junit.jupiter.api.Test;

class UserInputTest {

    @Test
    public void 사용자_입력값을_생성할_수_있다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2, 3);

        // when
        UserInput userInput = new UserInput(values);

        // then
        assertEquals(userInput.values, values);
    }

    @Test
    public void null로_사용자_입력값을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = null;

        // when
        // then
        assertThatThrownBy(() -> new UserInput(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 세자리_자리수가_아닌_수로_사용자_입력값을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2);

        // when
        // then
        assertThatThrownBy(() -> new UserInput(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 중복값으로_사용자_입력값을_생성하려하면_에러를_던진다() {
        // given
        List<Number> values = NumberFactory.createNumberList(1, 2, 2);

        // when
        // then
        assertThatThrownBy(() -> new UserInput(values))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 알파벳을_입력하면_에러를_던진다() {
        // given
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        // when
        // then
        for (char ch : alphabet) {
            assertThatThrownBy(() -> UserInput.checkValidChar(ch))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    // FIXME: 이모지까지 전부 검증할 순 없을까?
    @Test
    public void 특수문자를_입력하면_에러를_던진다() {
        // given
        char[] specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~".toCharArray();

        // when
        // then
        for (char ch : specialCharacters) {
            assertThatThrownBy(() -> UserInput.checkValidChar(ch))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void 일보다_작은_숫자를_입력하면_에러를_던진다() {
        // given
        char ch = '0';

        // when
        // then
        assertThatThrownBy(() -> UserInput.checkValidChar(ch))
            .isInstanceOf(IllegalArgumentException.class);
    }

}
