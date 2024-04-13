package baseball.repository;

import baseball.domain.Computer;
import baseball.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerRepositoryImplTest {
    private static final ComputerRepository computerRepository = new ComputerRepositoryImpl();

    @DisplayName("해당 컴퓨터를 조회할 수 있다.")
    @Test
    void findByIdTest() {
        Computer computer = new Computer(Arrays.asList(new Number(1), new Number(2), new Number(3)));

        int computerId = computerRepository.insert(computer);

        Computer findComputer = computerRepository.findById(computerId).get();

        assertThat(findComputer).isEqualTo(computer);
    }

    @DisplayName("컴퓨터를 저장할수 있다.")
    @Test
    void insertTest() {
        Computer computer = new Computer(Arrays.asList(new Number(1), new Number(2), new Number(3)));

        Integer computerId = computerRepository.insert(computer);

        assertThat(computerId).isNotNull();
    }
}
