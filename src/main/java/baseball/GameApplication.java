package baseball;

import baseball.controller.BaseBallGameController;
import baseball.domain.Command;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.generator.BaseBallNumberGenerator;
import baseball.generator.BaseBallNumberShuffleGenerator;
import baseball.repository.GameRepositoryImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public final class GameApplication {
    private static final BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberShuffleGenerator();
    private static final BaseBallGameController baseBallGameController = new BaseBallGameController(new GameRepositoryImpl());

    private GameApplication() {
    }

    public static void run() {
        Command command = Command.END;
        try {
            do {
                command = Command.of(InputView.inputMenu());
                final int gameId = baseBallGameController.startGame(baseBallNumberGenerator);
                OutputView.printPickComputerNumbers();
                executeGame(gameId);
            }
            while (command != Command.END);
            endApplication();
        } catch (final Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private static void endApplication() {
        OutputView.printExitMessage();
    }

    private static void executeGame(final int gameId) {
        try {
            boolean isInprogress = true;

            while (isInprogress) {
                final List<Integer> userNumbers = InputView.inputNumbers();
                final CheckBallsRequest checkBallsRequest = new CheckBallsRequest(userNumbers, gameId);
                final CheckBallResponse checkBallDto = baseBallGameController.checkBalls(checkBallsRequest);
                OutputView.printResult(checkBallDto);
                isInprogress = !checkBallDto.isSuccess();
            }
        } catch (final Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            executeGame(gameId);
        }
    }
}
