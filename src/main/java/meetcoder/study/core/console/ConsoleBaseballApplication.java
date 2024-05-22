package meetcoder.study.core.console;

import java.util.Map;
import meetcoder.study.core.BaseballApplication;
import meetcoder.study.core.command.Command;
import meetcoder.study.core.command.CommandFactory;
import meetcoder.study.core.command.ExitApplicationCommand;
import meetcoder.study.core.command.PlayGameCommand;
import meetcoder.study.service.RandomBallNumbersGenerator;
import meetcoder.study.view.ConsoleInputView;
import meetcoder.study.view.ConsoleOutputView;

public class ConsoleBaseballApplication implements BaseballApplication {

    private final ConsoleInputView inputView;
    private final ConsoleOutputView outputView;
    private final CommandFactory commandFactory;
    private boolean isRunning;

    public ConsoleBaseballApplication() {
        this.inputView = new ConsoleInputView();
        this.outputView = new ConsoleOutputView();
        this.commandFactory = new CommandFactory(
            Map.of(
                "1", new PlayGameCommand(
                    new ConsoleBaseballGame(
                        inputView, outputView, new RandomBallNumbersGenerator())),
                "9", new ExitApplicationCommand(this)
            )
        );
    }

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            processCommand();
        }
    }

    @Override
    public void exit() {
        outputView.displayGoodbyeMessage();
        isRunning = false;
    }

    private void processCommand() {
        try {
            outputView.displayManual();
            Command command = inputView.getCommand(commandFactory);
            command.excute();
        } catch (Exception ex) {
            outputView.displayError(ex);
        }
    }

}
