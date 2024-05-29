package baseball.common.exception;

public class InvalidLengthException extends Exception{

    private static final String MESSAGE = "자리 숫자만 가능합니다.";

    public InvalidLengthException(int length) {
        super(String.valueOf(length) + MESSAGE);
    }
}
