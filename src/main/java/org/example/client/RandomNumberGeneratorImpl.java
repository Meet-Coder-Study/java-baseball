package org.example.client;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomNumberGeneratorImpl implements RandomNumberGenerator {

    private static final Random random = new Random();

    @Override
    public List<Integer> getRandomNumbers() {
        Set<Integer> baseBallNumbers = new HashSet<>();
        while(baseBallNumbers.size() < 3) {
            int randomNum = random.nextInt(9) + 1;
            baseBallNumbers.add(randomNum);
        }

        return baseBallNumbers
            .stream()
            .toList();
    }

}
