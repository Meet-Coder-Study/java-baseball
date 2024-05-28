package baseball.exception;

public class InvalidGameStatusException extends Exception{

    public InvalidGameStatusException(String message) {
        super(message);
    }
}
