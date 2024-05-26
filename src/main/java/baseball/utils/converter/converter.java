package baseball.utils.converter;

import java.util.ArrayList;
import java.util.List;

public class converter {

    public static List<Integer> intToDigits(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(0, number % 10);
            number /= 10;
        }
        return digits;
    }
}
