package meetcoder.study.view.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import meetcoder.study.core.command.Command;
import meetcoder.study.core.command.CommandFactory;
import meetcoder.study.view.InputView;

public class ConsoleInputView implements InputView {

  private static final BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));
  private final CommandFactory commandFactory;

  public ConsoleInputView(CommandFactory commandFactory) {
    this.commandFactory = commandFactory;
  }

  @Override
  public Command getCommand() {
    return commandFactory.getCommand(readString());
  }

  private String readString() {
    try {
      return reader.readLine();
    } catch (Exception e) {
      throw new IllegalArgumentException("입력값을 읽을 수 없습니다.");
    }
  }

}
