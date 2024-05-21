package baseball.controller;

import baseball.domain.Number;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.repository.GameRepository;
import baseball.repository.GameRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class BaseBallGameControllerTest {

    private static final GameRepository gameRepository = new GameRepositoryImpl();
    private static final BaseBallGameController baseBallGameController = new BaseBallGameController(gameRepository);

    @DisplayName("게임을 시작한다.")
    @Test
    void GameStartTest() {
        final int gameId = baseBallGameController.gameStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        assertThat(gameRepository.findById(gameId)).isPresent();
    }

    @DisplayName("1스트라이크 1볼을 확인한다.")
    @Test
    void checkBallTest() {
        final int gameId = baseBallGameController.gameStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        final CheckBallResponse checkBallDto = baseBallGameController.checkBalls(new CheckBallsRequest(List.of(1, 3, 5), gameId));

        assertThat(checkBallDto.strikeCount()).isEqualTo(1);
        assertThat(checkBallDto.ballCount()).isEqualTo(1);
        assertThat(checkBallDto.isNotting()).isFalse();
        assertThat(checkBallDto.isSuccess()).isFalse();
    }

    @DisplayName("낫싱을 확인한다.")
    @Test
    void checkBallTest2() {
        final int gameId = baseBallGameController.gameStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        final CheckBallResponse checkBallDto = baseBallGameController.checkBalls(new CheckBallsRequest(List.of(4, 5, 6), gameId));

        assertAll(() -> assertThat(checkBallDto.strikeCount()).isZero(),
                () -> assertThat(checkBallDto.ballCount()).isZero(),
                () -> assertThat(checkBallDto.isNotting()).isTrue(),
                () -> assertThat(checkBallDto.isSuccess()).isFalse()
        );
    }

    @DisplayName("3스트라이크를 확인한다.")
    @Test
    void checkBallTest3() {
        final int gameId = baseBallGameController.gameStart(() -> List.of(
                new Number(1), new Number(2), new Number(3)));

        final CheckBallResponse checkBallDto = baseBallGameController.checkBalls(new CheckBallsRequest(List.of(1, 2, 3), gameId));

        assertAll(() -> assertThat(checkBallDto.strikeCount()).isEqualTo(3),
                () -> assertThat(checkBallDto.ballCount()).isZero(),
                () -> assertThat(checkBallDto.isNotting()).isFalse(),
                () -> assertThat(checkBallDto.isSuccess()).isTrue()
        );
    }
}
