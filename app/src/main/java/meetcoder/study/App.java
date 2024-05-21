package meetcoder.study;

import meetcoder.study.core.BaseballApplication;
import meetcoder.study.core.console.ConsoleBaseballApplication;
import meetcoder.study.view.console.ConsoleInputView;
import meetcoder.study.view.console.ConsoleOutputView;

public class App {

  public static void main(String[] args) {
    BaseballApplication application = new ConsoleBaseballApplication(
        new ConsoleInputView(),
        new ConsoleOutputView()
    );

    application.start();
  }

}
