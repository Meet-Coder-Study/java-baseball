package baseball.repository;

import baseball.domain.Computer;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ComputerRepositoryImpl implements ComputerRepository {
    private static final Map<Integer, Computer> COMPUTERS = new HashMap<>();
    private static Integer id = 0;

    @Override
    public Optional<Computer> findById(Integer id) {
        return Optional.of(COMPUTERS.get(id));
    }

    @Override
    public Integer insert(Computer computer) {
        id++;
        COMPUTERS.put(id, computer);

        return id;
    }
}
