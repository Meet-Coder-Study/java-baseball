package org.example.domain;

import java.util.List;

public class InputNumber extends Number {

    public InputNumber(List<Integer> values) {
        super(values);
    }

    public static void checkValidChar(final char ch) {
        if (isInvalidDigit(ch)) {
            throw new IllegalArgumentException("각 자리수는 1~9 사이의 자연수여야 합니다.");
        }
    }

    private static boolean isInvalidDigit(final char ch) {
        if (!Character.isDigit(ch)) {
            return true;
        }
        final int value = Character.getNumericValue(ch);
        return value < MIN_NUMBER || value > MAX_NUMBER;
    }

}
