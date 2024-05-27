package org.example.adapter.enums;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MenuTest {

    @ParameterizedTest
    @CsvSource({
        "1, START",
        "9, QUIT"
    })
    void 유효한_value에_해당하는_Menu를_조회할_수_있다(String value, Menu expectedMenu) {
        assertEquals(expectedMenu, Menu.from(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "2", "10", "a", ""})
    void 유효하지_않은_value를_검색하면_에러를_던진다(String value) {
        assertThatThrownBy(() -> Menu.from(value))
            .isInstanceOf(IllegalStateException.class);
    }

    @Test
    public void value_9로_생성한_메뉴는_Quit_이다() {
        // given
        String value = "9";

        // when
        boolean isNotQuit = Menu.isNotQuit(value);

        // then
        assertFalse(isNotQuit);
    }

    @Test
    @DisplayName("9가 아닌 값으로 생성한 메뉴는 Quit이 아니다.")
    public void value_9가_아닌_값으로_생성한_메뉴는_Quit이_아니다() {
        // given
        String value = "1";

        // when
        boolean isNotQuit = Menu.isNotQuit(value);

        // then
        assertTrue(isNotQuit);
    }

}
