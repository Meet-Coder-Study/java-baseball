package baseball.controller;

import baseball.domain.BaseBallNumbers;
import baseball.domain.Game;
import baseball.domain.Number;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.factory.BaseBallNumberFactory;
import baseball.generator.BaseBallNumberGenerator;
import baseball.repository.GameRepository;

public class BaseBallGameController {
    private static final int ALL_STRIKE_CONT = 3;

    private final GameRepository gameRepository;

    public BaseBallGameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public int gameStart(BaseBallNumberGenerator baseBallNumberGenerator) {
        Game game = new Game(baseBallNumberGenerator.generate());

        return gameRepository.insert(game);
    }

    public CheckBallResponse checkBalls(CheckBallsRequest checkBallsRequest) {
        Game game = gameRepository.findById(checkBallsRequest.gameId())
                .orElseThrow(() -> new IllegalArgumentException("컴퓨터가 존재하지 않습니다."));

        BaseBallNumbers playerNumbers = getPlayerNumbers(checkBallsRequest);

        if (game.isSameNumbers(playerNumbers)) {
            return new CheckBallResponse(ALL_STRIKE_CONT, 0, false, true);
        }

        int ballNumber = 0;
        int strikeNumber = 0;

        for (Number number : playerNumbers.getNumbers()) {
            if (game.isStrike(number, playerNumbers.indexOf(number))) {
                strikeNumber++;
            } else if (game.isBall(number)) {
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
