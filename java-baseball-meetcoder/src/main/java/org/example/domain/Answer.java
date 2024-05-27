package org.example.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {

    public List<Number> values;

    public static final int START_INDEX = 0;
    public static final int LENGTH = 3;

    public Answer(List<Number> values) {
        this.values = values;
        checkNull(values);
        checkLength(values);
        checkHasDuplicate(values);
    }

    private void checkNull(List<Number> values) {
        if (values == null) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }

    private void checkLength(List<Number> values) {
        if (values.size() != LENGTH) {
            throw new IllegalArgumentException("3자리의 자연수를 입력해주세요.");
        }
    }

    private void checkHasDuplicate(List<Number> values) {
        if (hasDuplicateValue(values)) {
            throw new IllegalArgumentException("중복 없는 3자리 자연수를 입력해주세요.");
        }
    }

    private boolean hasDuplicateValue(List<Number> values) {
        Set<Number> checks = new HashSet<>(values);
        return checks.size() < LENGTH;
    }

}
