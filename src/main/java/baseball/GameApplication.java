package baseball;

import baseball.controller.BaseBallGameController;
import baseball.domain.Commend;
import baseball.dto.CheckBallResponse;
import baseball.dto.CheckBallsRequest;
import baseball.generator.BaseBallNumberGenerator;
import baseball.generator.BaseBallNumberShuffleGenerator;
import baseball.repository.ComputerRepositoryImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameApplication {
    private static final BaseBallNumberGenerator baseBallNumberGenerator = new BaseBallNumberShuffleGenerator();
    private static final BaseBallGameController baseBallGameController = new BaseBallGameController(new ComputerRepositoryImpl());

    public static void run() {
        Commend commend = Commend.END;
        try {
            do {
                commend = Commend.of(InputView.inputMenu());
                int computerId = baseBallGameController.computerStart(baseBallNumberGenerator);
                OutputView.printPickComputerNumbers();
                gameInProgress(computerId);
            }
            while (commend != Commend.END);
            applicationEnd();
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            run();
        }
    }

    private static void applicationEnd() {
        OutputView.printExitMessage();
    }

    private static void gameInProgress(int computerId) {
        try {
            boolean isFinished = true;

            while (isFinished) {
                List<Integer> userNumbers = InputView.inputNumbers();
                CheckBallsRequest checkBallsRequest = new CheckBallsRequest(userNumbers, computerId);
                CheckBallResponse checkBallDto = baseBallGameController.checkBalls(checkBallsRequest);
                OutputView.printResult(checkBallDto);
                isFinished = !checkBallDto.isSuccess();
            }
        } catch (Exception e) {
            OutputView.printErrorMessage(e.getMessage());
            gameInProgress(computerId);
        }
    }
}
