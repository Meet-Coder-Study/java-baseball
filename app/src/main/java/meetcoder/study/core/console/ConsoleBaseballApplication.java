package meetcoder.study.core.console;

import java.util.Map;
import meetcoder.study.core.BaseballApplication;
import meetcoder.study.core.command.Command;
import meetcoder.study.core.command.CommandFactory;
import meetcoder.study.core.command.ExitApplicationCommand;
import meetcoder.study.core.command.PlayGameCommand;
import meetcoder.study.view.InputView;
import meetcoder.study.view.OutputView;
import meetcoder.study.view.console.ConsoleInputView;
import meetcoder.study.view.console.ConsoleOutputView;

public class ConsoleBaseballApplication implements BaseballApplication {

  private final InputView inputView;
  private final OutputView outputView;
  private boolean isRunning;

  public ConsoleBaseballApplication() {
    this.inputView = new ConsoleInputView(
        new CommandFactory(
            Map.of(
                "1", new PlayGameCommand(),
                "9", new ExitApplicationCommand(this)
            )
        )
    );
    this.outputView = new ConsoleOutputView();
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
      Command command = inputView.getCommand();
      command.excute();
    } catch (Exception ex) {
      outputView.displayError(ex);
    }
  }

}
