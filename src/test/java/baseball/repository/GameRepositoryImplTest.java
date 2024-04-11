package baseball.repository;

import baseball.domain.Game;
import baseball.domain.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameRepositoryImplTest {
    private static final GameRepository GAME_REPOSITORY = new GameRepositoryImpl();

    @DisplayName("해당 컴퓨터를 조회할 수 있다.")
    @Test
    void findByIdTest() {
        Game game = new Game(Arrays.asList(new Number(1), new Number(2), new Number(3)));

        int gameId = GAME_REPOSITORY.insert(game);

        Game findGame = GAME_REPOSITORY.findById(gameId).get();

        assertThat(findGame).isEqualTo(game);
    }

    @DisplayName("컴퓨터를 저장할수 있다.")
    @Test
    void insertTest() {
        Game game = new Game(Arrays.asList(new Number(1), new Number(2), new Number(3)));

        Integer gameId = GAME_REPOSITORY.insert(game);

        assertThat(gameId).isNotNull();
    }
}
