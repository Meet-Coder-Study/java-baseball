package baseball.controller;

import baseball.domain.Number;
import baseball.dto.CheckBallRequest;
import baseball.dto.CheckBallResponse;
import baseball.repository.ComputerRepository;
import baseball.repository.ComputerRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseBallGameControllerTest {

    private static final ComputerRepository computerRepository = new ComputerRepositoryImpl();
    private static final BaseBallGameController baseBallGameController = new BaseBallGameController(computerRepository);

    @DisplayName("컴퓨터를 생성한다.")
    @Test
    void computerStartTest() {
        int computerId = baseBallGameController.computerStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        assertThat(computerRepository.findById(computerId)).isPresent();
    }

    @DisplayName("1스트라이크 1볼을 확인한다.")
    @Test
    void checkBallTest() {
        int computerId = baseBallGameController.computerStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        CheckBallResponse checkBallDto = baseBallGameController.checkBall(new CheckBallRequest(List.of(1, 3, 5), computerId));

        assertThat(checkBallDto.strikeCont()).isEqualTo(1);
        assertThat(checkBallDto.ballCont()).isEqualTo(1);
        assertThat(checkBallDto.isNotting()).isFalse();
        assertThat(checkBallDto.isSuccess()).isFalse();
    }

    @DisplayName("낫싱을 확인한다.")
    @Test
    void checkBallTest2() {
        int computerId = baseBallGameController.computerStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        CheckBallResponse checkBallDto = baseBallGameController.checkBall(new CheckBallRequest(List.of(4, 5, 6), computerId));

        assertAll(() -> assertThat(checkBallDto.strikeCont()).isZero(),
                () -> assertThat(checkBallDto.ballCont()).isZero(),
                () -> assertThat(checkBallDto.isNotting()).isTrue(),
                () -> assertThat(checkBallDto.isSuccess()).isFalse()
        );
    }

    @DisplayName("3스트라이크를 확인한다.")
    @Test
    void checkBallTest3() {
        int computerId = baseBallGameController.computerStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        CheckBallResponse checkBallDto = baseBallGameController.checkBall(new CheckBallRequest(List.of(1, 2, 3), computerId));

        assertAll(() -> assertThat(checkBallDto.strikeCont()).isEqualTo(3),
                () -> assertThat(checkBallDto.ballCont()).isZero(),
                () -> assertThat(checkBallDto.isNotting()).isFalse(),
                () -> assertThat(checkBallDto.isSuccess()).isTrue()
        );
    }
}
