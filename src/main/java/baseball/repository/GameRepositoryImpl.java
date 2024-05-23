package baseball.repository;

import baseball.domain.Game;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GameRepositoryImpl implements GameRepository {
    private static final Map<Integer, Game> GAMES = new HashMap<>();
    private static Integer id = 0;

    @Override
    public Optional<Game> findById(final Integer id) {
        return Optional.of(GAMES.get(id));
    }

    @Override
    public Integer insert(final Game game) {
        id++;
        GAMES.put(id, game);

        return id;
    }
}
