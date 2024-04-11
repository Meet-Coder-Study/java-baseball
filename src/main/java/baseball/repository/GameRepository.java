package baseball.repository;

import baseball.domain.Game;

import java.util.Optional;

public interface GameRepository {
    Optional<Game> findById(Integer id);

    Integer insert(Game game);
}
