package meetcoder.study.core.command;

import meetcoder.study.core.BaseballGame;

public class PlayGameCommand implements Command {

  private final BaseballGame game;

  public PlayGameCommand(BaseballGame game) {
    this.game = game;
  }

  @Override
  public void excute() {
    game.play();
  }

}
