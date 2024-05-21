package meetcoder.study.core.console;

import meetcoder.study.core.BaseballApplication;
import meetcoder.study.core.command.Command;
import meetcoder.study.view.InputView;
import meetcoder.study.view.OutputView;

public class ConsoleBaseballApplication implements BaseballApplication {

  private final InputView inputView;
  private final OutputView outputView;
  private boolean isRunning;

  public ConsoleBaseballApplication(InputView inputView, OutputView outputView) {
    this.inputView = inputView;
    this.outputView = outputView;
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
