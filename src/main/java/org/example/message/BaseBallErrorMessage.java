package org.example.message;

public class BaseBallErrorMessage {

    private BaseBallErrorMessage(){}

    public static final String INVALID_USER_NUMBER_GUESS = "예측하는 숫자는 서로 다른 3자리의 정수로 입력해주세요";
    public static final String NON_NUMBER_INPUT_ERROR = "숫자를 정확히 입력해주세요";
    public static final String INVALID_START_OR_END_NUMBER = "유효하지 않은 시작 혹은 종료 숫자 입니다. 1 또는 9를 정확히 입력해주세요";

}
