package org.example.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record InputNumber(
    List<Integer> values
) {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int LENGTH = 3;

    public InputNumber {
        if (values == null) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
        if (values.size() != LENGTH) {
            throw new IllegalArgumentException("3자리의 자연수를 입력해주세요.");
        }
        if (hasDuplicateValue(values)) {
            throw new IllegalArgumentException("중복 없는 3자리 자연수를 입력해주세요.");
        }
    }

    public static void checkValidChar(final char ch) {
        if (isInvalidDigit(ch)) {
            throw new IllegalArgumentException("각 자리수는 1~9 사이의 자연수여야 합니다.");
        }
    }

    private static boolean isInvalidDigit(final char ch) {
        if (!Character.isDigit(ch)) {
            return false;
        }
        final int value = Character.getNumericValue(ch);
        return value < MIN_NUMBER || value > MAX_NUMBER;
    }

    private boolean hasDuplicateValue(List<Integer> values) {
        Set<Integer> checks = new HashSet<>(values);
        return checks.size() < LENGTH;
    }

}
