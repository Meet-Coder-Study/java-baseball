package meetcoder.study.core.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

  private final Map<String, Command> commandMap;

  public CommandFactory(Map<String, Command> commandMap) {
    this.commandMap = new HashMap<>(commandMap);
  }

  public Command getCommand(String key) {
    if (commandMap.containsKey(key)) {
      return commandMap.get(key);
    }

    throw new IllegalArgumentException("존재하지 않는 명령어입니다.");
  }

}
