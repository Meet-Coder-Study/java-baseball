package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    private static final int COMPUTER_DIGITS_SIZE = 3;

    public List<Integer> generateRandomDigits() {
        List<Integer> digits = new ArrayList<>();

        while (digits.size() < COMPUTER_DIGITS_SIZE) {
            Random random = new Random();
            int randomNumber = random.nextInt(9) + 1;
            addToDigits(digits, randomNumber);
        }

        return digits;
    }

    private void addToDigits(List<Integer> digits, int randomNumber) {
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber);
        }
    }
}
