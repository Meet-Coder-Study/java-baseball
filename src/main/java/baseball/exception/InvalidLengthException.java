package baseball.exception;

public class InvalidLengthException extends Exception{

    private static final String MESSAGE = "자리 숫자만 가능합니다.";

    public InvalidLengthException(int m) {
        super(String.valueOf(m) + MESSAGE);
    }
}
