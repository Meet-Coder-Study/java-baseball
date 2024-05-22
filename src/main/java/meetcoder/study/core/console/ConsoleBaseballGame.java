package meetcoder.study.core.console;

import meetcoder.study.core.BaseballGame;
import meetcoder.study.model.BallNumbers;
import meetcoder.study.model.BaseballGuessResult;
import meetcoder.study.service.BallNumbersGenerator;
import meetcoder.study.view.ConsoleInputView;
import meetcoder.study.view.ConsoleOutputView;

public class ConsoleBaseballGame implements BaseballGame {

    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final BallNumbersGenerator ballNumbersGenerator;
    private BallNumbers targetNumbers;
    private boolean isRunning;

    public ConsoleBaseballGame(
        ConsoleInputView inputView, ConsoleOutputView outputView,
        BallNumbersGenerator ballNumbersGenerator
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ballNumbersGenerator = ballNumbersGenerator;
    }

    @Override
    public void play() {
        isRunning = true;
        targetNumbers = ballNumbersGenerator.generate();
        outputView.displaySetUpComplete();
        while (isRunning) {
            guess();
        }
    }

    private void guess() {
        try {
            outputView.displayNumberInputRequest();
            BallNumbers guessedNumbers = inputView.readBaseballNumber();
            BaseballGuessResult result = targetNumbers.evaluateGuess(guessedNumbers);
            outputView.printBaseballResult(result);
            if (result.isAllStrike()) {
                end();
            }
        } catch (Exception ex) {
            outputView.displayError(ex);
        }
    }

    private void end() {
        outputView.displayGameOver();
        isRunning = false;
    }

}
