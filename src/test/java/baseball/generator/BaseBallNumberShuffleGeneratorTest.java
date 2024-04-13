package baseball.generator;

import baseball.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseBallNumberShuffleGeneratorTest {
    @DisplayName("중복되지 않는 3개의 숫자를 추출한다.")
    @Test
    void generateTest() {
        BaseBallNumberShuffleGenerator baseBallNumberShuffleGenerator = new BaseBallNumberShuffleGenerator();

        List<Number> baseBallNumbers = baseBallNumberShuffleGenerator.generate();

        assertThat(baseBallNumberShuffleGenerator.generate()).hasSize(3);
        assertThat(baseBallNumbers).doesNotHaveDuplicates();
    }
}
