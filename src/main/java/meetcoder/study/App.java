package meetcoder.study;

import meetcoder.study.core.BaseballApplication;
import meetcoder.study.core.console.ConsoleBaseballApplication;

public class App {

  public static void main(String[] args) {
    BaseballApplication application = new ConsoleBaseballApplication();
    application.run();
  }

}
