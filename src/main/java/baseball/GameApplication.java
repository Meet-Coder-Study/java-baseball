package baseball;

import baseball.controller.BaseBallGameController;
import baseball.domain.Commend;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.generator.BaseBallNumberGenerator;
import baseball.generator.BaseBallNumberShuffleGenerator;
import baseball.repository.GameRepositoryImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameApplication {
    private static final BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberShuffleGenerator();
    private static final BaseBallGameController baseBallGameController = new BaseBallGameController(new GameRepositoryImpl());

    private GameApplication() {
    }

    public static void run() {
        Commend commend = Commend.END;
        try {
            do {
                commend = Commend.of(InputView.inputMenu());
                final int gameId = baseBallGameController.gameStart(baseBallNumberGenerator);
                OutputView.printPickComputerNumbers();
                gameInProgress(gameId);
            }
            while (commend != Commend.END);
            applicationEnd();
        } catch (final Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private static void applicationEnd() {
        OutputView.printExitMessage();
    }

    private static void gameInProgress(final int gameId) {
        try {
            boolean isFinished = true;

            while (isFinished) {
                final List<Integer> userNumbers = InputView.inputNumbers();
                final CheckBallsRequest checkBallsRequest = new CheckBallsRequest(userNumbers, gameId);
                final CheckBallResponse checkBallDto = baseBallGameController.checkBalls(checkBallsRequest);
                OutputView.printResult(checkBallDto);
                isFinished = !checkBallDto.isSuccess();
            }
        } catch (final Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            gameInProgress(gameId);
        }
    }
}
