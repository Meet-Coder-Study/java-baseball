package sehee.util.numbermaker;

import static org.assertj.core.api.Assertions.assertThat;
import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomNumberMakerTest {

    private RandomNumberMaker numberMaker;

    @BeforeEach
    void setup() {
        numberMaker = new RandomNumberMaker(new Random());
    }

    @Nested
    class MakeTest {

        @Test
        @DisplayName("1~9 사이의 1자리 랜덤 숫자를 만들 수 있다.")
        void successMake() {
            // given, when
            int randomNumber = numberMaker.make();

            // then
            assertThat(randomNumber).isBetween(1, 9);
        }

    }

    @Nested
    class makeAllUnique {

        @Test
        @DisplayName("1~9 사이의 랜덤 유니크 숫자를 " + ANSWER_LENGTH + "자로 만들 수 있다.")
        void successMakeAllUnique() {
            // given, when
            int[] randomUniqueNumbers = numberMaker.makeAllUnique();

            int[] numberExistCount = new int[10];
            for (int number : randomUniqueNumbers) {
                numberExistCount[number]++;
            }

            // then
            assertThat(randomUniqueNumbers).hasSize(ANSWER_LENGTH);
            assertThat(numberExistCount).containsAnyOf(0, 1);
        }

    }

}
