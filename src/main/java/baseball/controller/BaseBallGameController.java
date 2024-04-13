package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.Computer;
import baseball.domain.Number;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.factory.BaseBallNumberFactory;
import baseball.generator.BaseBallNumberGenerator;
import baseball.repository.ComputerRepository;

public class BaseBallGameController {
    private static final int ALL_STRIKE_CONT = 3;

    private final ComputerRepository computerRepository;

    public BaseBallGameController(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public int computerStart(BaseBallNumberGenerator baseBallNumberGenerator) {
        Computer computer = new Computer(baseBallNumberGenerator.generate());

        return computerRepository.insert(computer);
    }

    public CheckBallResponse checkBalls(CheckBallsRequest checkBallsRequest) {
        Computer computer = computerRepository.findById(checkBallsRequest.computerId())
                .orElseThrow(() -> new IllegalArgumentException("컴퓨터가 존재하지 않습니다."));

        BaseBallNumbers playerNumbers = getPlayerNumbers(checkBallsRequest);

        if (computer.isSameNumbers(playerNumbers)) {
            return new CheckBallResponse(ALL_STRIKE_CONT, 0, false, true);
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

        return new CheckBallResponse(strikeNumber, ballNumber, isNotting(strikeNumber, ballNumber), false);
    }

    private BaseBallNumbers getPlayerNumbers(CheckBallsRequest checkBallsRequest) {
        return new BaseBallNumbers(
                checkBallsRequest.userNumbers()
                        .stream()
                        .map(BaseBallNumberFactory::valueOf)
                        .toList()
        );
    }

    private boolean isNotting(int strikeCount, int ballCount) {
        return strikeCount == 0 && ballCount == 0;
    }
}
