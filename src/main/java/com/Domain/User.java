package com.Domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public static final int ZERO = 0;
    public static final int THREE_LETTERS = 3;

    private final List<Integer> userNums;

    public User(String inp) {
        Character[] userNums = inp.strip().chars()
                                  .mapToObj(e -> (char) e)
                                  .toArray(Character[]::new);

        if(!isThreeLetters(userNums)
           || !isAllDigits(userNums)
           || isDuplicated(userNums)
           || isZeroInit(userNums)) {
           throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }

        this.userNums = Arrays.stream(userNums)
                              .map(e -> Character.getNumericValue(e))
                              .collect(Collectors.toList());
    }

    public boolean isThreeLetters(Character[] userNums) {
        return userNums.length == THREE_LETTERS;
    }

    public boolean isAllDigits(Character[] userNums) {
        for (char letter: userNums) {
            if(!Character.isDigit(letter)) {
                return false;
            }
        }
        return true;
    }

    public boolean isDuplicated(Character[] userNums) {
        return Arrays.stream(userNums)
                     .distinct()
                     .count() != THREE_LETTERS;
    }

    public boolean isZeroInit(Character[] userNums) {
        return Arrays.stream(userNums)
                     .filter(e -> Character.getNumericValue(e) == ZERO)
                     .count() > ZERO;
    }

    public List<Integer> getuserNums() {
        return this.userNums;
    }
}