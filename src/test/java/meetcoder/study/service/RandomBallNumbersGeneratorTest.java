package meetcoder.study.service;

import static org.assertj.core.api.Assertions.assertThat;

import meetcoder.study.model.BallNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomBallNumbersGeneratorTest {

    RandomBallNumbersGenerator randomBallNumbersGenerator;

    @BeforeEach
    void setUp() {
        randomBallNumbersGenerator = new RandomBallNumbersGenerator();
    }

    @DisplayName("랜덤으로 생성된 BallNumbers를 반환한다.")
    @Test
    void generateBallNumbersRandomly() {
        // when
        BallNumbers generated = randomBallNumbersGenerator.generate();

        // then
        assertThat(generated).isNotNull();
    }

}
