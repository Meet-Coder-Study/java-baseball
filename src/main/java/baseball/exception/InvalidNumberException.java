package baseball.exception;

public class InvalidNumberException extends Exception{

    private static final String MESSAGE = "서로 다른 숫자만 가능합니다.";

    public InvalidNumberException() {
        super(MESSAGE);
    }
}
