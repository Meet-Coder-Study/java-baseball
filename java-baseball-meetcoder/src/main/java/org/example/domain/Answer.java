package org.example.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record Answer(
    List<Integer> values
) {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int START_INDEX = 0;
    public static final int LENGTH = 3;

    public Answer {
        if (values == null) {
            throw new IllegalArgumentException("게임 정답은 null일 수 없습니다.");
        }
        if (values.size() != LENGTH) {
            throw new IllegalArgumentException("게임 정답은 3자리의 자연수입니다.");
        }
        if (hasDuplicateValue()) {
            throw new IllegalArgumentException("게임 정답에는 중복 숫자가 없어야 합니다.");
        }
    }

    private boolean hasDuplicateValue() {
        Set<Integer> checks = new HashSet<>(values);
        return checks.size() < LENGTH;
    }

}
