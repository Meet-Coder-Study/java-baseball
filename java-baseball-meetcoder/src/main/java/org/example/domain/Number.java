package org.example.domain;

public record Number(
    Integer value
) {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public Number {
        checkValid(value);
    }

    private void checkValid(Integer value) {
        if (MIN_NUMBER > value || value > MAX_NUMBER) {
            throw new IllegalArgumentException("각 자리수는 1에서 9 사이의 자연수여야 합니다.");
        }
    }

}
