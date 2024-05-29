package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 길이를_검증한다() {
        // when
        List<Integer> result = computer.generateRandomDigits();

        // then
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void 중복을_검증한다() {
        // when
        List<Integer> result = computer.generateRandomDigits();

        // then
        assertThat(result).doesNotHaveDuplicates();
    }
}