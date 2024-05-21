package meetcoder.study.view;

import static meetcoder.study.model.BallNumbers.BALL_NUMBERS_SIZE;

final class ConsoleMessage {

  /**
   * 어플리케이션
   */
  static final String COMMAND_DESCRIPTION = "게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.";
  static final String GOOD_BYE_MESSAGE = "애플리케이션이 종료되었습니다.";

  /**
   * 야구 게임
   */
  static final String SETUP_MESSAGE = "컴퓨터가 숫자를 뽑았습니다.";
  static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요";
  static final String CLEAR_MESSAGE =
      BALL_NUMBERS_SIZE + "개의 숫자를 모두 맞히셨습니다.";
  static final String END_MESSAGE = "게임 종료";

}
