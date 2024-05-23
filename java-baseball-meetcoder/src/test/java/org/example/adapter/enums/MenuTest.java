package org.example.adapter.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {

    @Test
    @DisplayName("9가 아닌 값으로 생성한 메뉴는 Quit이 아니다.")
    public void checkQuit() {
        // given
        String value = "1";

        // when
        boolean isNotQuit = Menu.isNotQuit(value);

        // then
        assertTrue(isNotQuit);
    }

    @Test
    public void 제공하지_않는_옵션의_메뉴를_생성하려하면_에러를_던진다() {
        // given
        String value = "@##$";

        // when
        // then
        assertThatThrownBy(() -> Menu.from(value))
            .isInstanceOf(IllegalStateException.class);
    }

}
