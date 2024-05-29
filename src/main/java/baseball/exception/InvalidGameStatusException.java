package baseball.exception;

public class InvalidGameStatusException extends Exception{

    private static final String MESSAGE = "1(시작) 또는 9(종료)를 눌러주세요.";

    public InvalidGameStatusException() {
        super(MESSAGE);
    }
}
