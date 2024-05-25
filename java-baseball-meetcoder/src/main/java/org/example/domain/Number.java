package org.example.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Number {

    public List<Integer> values;

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int START_INDEX = 0;
    public static final int LENGTH = 3;

    public Number(List<Integer> values) {
        this.values = values;
        checkNull(values);
        checkLength(values);
        checkHasDuplicate(values);
    }

    private void checkNull(List<Integer> values) {
        if (values == null) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkLength(List<Integer> values) {
        if (values.size() != LENGTH) {
            throw new IllegalArgumentException("3자리의 자연수를 입력해주세요.");
        }
    }

    private void checkHasDuplicate(List<Integer> values) {
        if (hasDuplicateValue(values)) {
            throw new IllegalArgumentException("중복 없는 3자리 자연수를 입력해주세요.");
        }
    }

    private boolean hasDuplicateValue(List<Integer> values) {
        Set<Integer> checks = new HashSet<>(values);
        return checks.size() < LENGTH;
    }

}
