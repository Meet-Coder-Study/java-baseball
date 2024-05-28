package sehee.util.constant;

import static sehee.util.constant.NumberBaseballGameConstant.ANSWER_LENGTH;

public final class NumberBaseballGameMessage {

    public static final String COMPUTER_CHOOSE_NUMBERS_MESSAGE = "컴퓨터가 " + ANSWER_LENGTH + "자의 중복 없는 숫자를 뽑았습니다.";
    public static final String WRITE_NUMBERS_MESSAGE = ANSWER_LENGTH + "자의 숫자를 중복 없이 입력해주세요: ";
    public static final String ALL_STRIKE_MESSAGE = ANSWER_LENGTH + "자의 숫자를 모두 맞히셨습니다.";
    public static final String GAME_OVER_MESSAGE = "-------게임 종료-------";
    public static final String ANSWER_LENGTH_EXCEPTION_MESSAGE = ANSWER_LENGTH + "자의 숫자로 입력해주세요.";
    public static final String DUPLICATED_EXCEPTION_MESSAGE = "1~9 사이의 모두 다른 숫자여야합니다.";

}
