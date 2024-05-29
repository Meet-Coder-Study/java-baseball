package baseball.common.utils;

import java.util.ArrayList;
import java.util.List;

public class converter {

    /**
     *  int를 맨 앞 자리부터 하나씩 리스트로 변환
     */
    public static List<Integer> intToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }
}
