package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.Computer;
import baseball.domain.Number;
import baseball.dto.CheckBallRequest;
import baseball.dto.CheckBallResponse;
import baseball.generator.BaseBallNumberGenerator;
import baseball.repository.ComputerRepository;

public class BaseBallGameController {
    private final ComputerRepository computerRepository;

    public BaseBallGameController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public int computerStart(BaseBallNumberGenerator baseBallNumberGenerator) {
        Computer computer = new Computer(baseBallNumberGenerator.generate());

        return computerRepository.create(computer);
    }

    public CheckBallResponse checkBall(CheckBallRequest checkBallRequest) {
        Computer computer = computerRepository.findById(checkBallRequest.computerId())
                .orElseThrow(() -> new IllegalArgumentException("컴퓨터가 존재하지 않습니다."));

        BaseBallNumbers playerNumbers = new BaseBallNumbers(
                checkBallRequest.userNumbers()
                        .stream()
                        .map(Number::new)
                        .toList()
        );

        if (computer.isSameNumbers(playerNumbers)) {
            return new CheckBallResponse(3, 0, false, true);
        }

        int ballNumber = 0;
        int strikeNumber = 0;

        for (Number number : playerNumbers.getNumbers()) {
            if (computer.isStrike(number, playerNumbers.indexOf(number))) {
                strikeNumber++;
            } else if (computer.isBall(number)) {
                ballNumber++;
            }
        }

        boolean isNotting = ballNumber == 0 && strikeNumber == 0;

        return new CheckBallResponse(strikeNumber, ballNumber, isNotting, false);
    }
}
