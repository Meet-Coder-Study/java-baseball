package org.example.client;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorImplTest {

    @Test
    @DisplayName("정상적으로 랜덤한 세 자리 수 숫자를 반환한다.")
    void generateRandomNumberTest() {
        //given
        RandomNumberGenerator generator = new RandomNumberGeneratorImpl();

        //when
        List<Integer> randomNumbers = generator.getRandomNumbers();

        //then
        Assertions.assertThat(randomNumbers).hasSize(3);
        List<Integer> distinctNumber = randomNumbers
            .stream()
            .filter(number -> number < 10)
            .distinct()
            .toList();
        Assertions.assertThat(distinctNumber).hasSize(3);
    }

}
