package meetcoder.study.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import meetcoder.study.core.command.Command;
import meetcoder.study.core.command.CommandFactory;
import meetcoder.study.model.BallNumbers;

public class ConsoleInputView {

  private static final BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));

  public Command getCommand(CommandFactory commandFactory) {
    return commandFactory.getCommand(readString());
  }

  public BallNumbers readBaseballNumber() {
    return BallNumbers.of(readInts());
  }

  private String readString() {
    try {
      return reader.readLine();
    } catch (Exception e) {
      throw new IllegalArgumentException("입력값을 읽을 수 없습니다.");
    }
  }

  private List<Integer> readInts() {
    try {
      return readString().chars()
          .boxed()
          .map(Character::getNumericValue)
          .toList();
    } catch (Exception e) {
      throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
  }


}
