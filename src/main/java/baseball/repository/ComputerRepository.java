package baseball.repository;

import baseball.domain.Computer;

import java.util.Optional;

public interface ComputerRepository {
    Optional<Computer> findById(Integer id);

    Integer insert(Computer computer);
}
