package meetcoder.study.view.console;

import static meetcoder.study.view.console.ConsoleMessage.COMMAND_DESCRIPTION;
import static meetcoder.study.view.console.ConsoleMessage.GOOD_BYE_MESSAGE;

import meetcoder.study.view.OutputView;

public class ConsoleOutputView implements OutputView {

  @Override
  public void displayManual() {
    println(COMMAND_DESCRIPTION);
  }

  @Override
  public void displayError(Exception ex) {
    println("⚠️" + ex.getMessage());
  }

  @Override
  public void displayGoodbyeMessage() {
    println(GOOD_BYE_MESSAGE);
  }

  private void println(String message) {
    System.out.println(message);
  }

}
