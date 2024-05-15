package com.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("세글자 입력이 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1234", ""})
    void 세글자_입력(String userInput) {
        assertThatThrownBy(() -> new User(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 입력값이 존재하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"abc", "ABC", "@%(", "a9!"})
    void 숫자_아닌경우(String userInput) {
        assertThatThrownBy(() -> new User(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복되는 숫자가 존재하는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"112", "131", "111", "511"})
    void 중복되는_숫자(String userInput) {
        assertThatThrownBy(() -> new User(userInput)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0이 포함되는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"012", "101", "110"})
    void 숫자0_포함(String userInput) {
        assertThatThrownBy(() -> new User(userInput)).isInstanceOf(IllegalArgumentException.class);
    }
}