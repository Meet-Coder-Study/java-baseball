package baseball.presentation;

import baseball.domain.Computer;
import baseball.exception.InvalidLengthException;
import baseball.exception.InvalidNumberException;

import java.util.*;

import static baseball.utils.converter.converter.intToDigits;

public class GameManager {

    private static final int USER_DIGITS_SIZE = 3;
    private static final Scanner scanner = new Scanner(System.in);

    private final MessagePrinter messagePrinter;

    public GameManager(MessagePrinter messagePrinter) {
        this.messagePrinter = messagePrinter;
    }

    public GameStatus init() {
        GameStatus gameStatus;
        do {
            try {
                messagePrinter.initMessage();
                String input = String.valueOf(scanner.nextInt());
                gameStatus = GameStatus.find(input);
                break;
            } catch (Exception e) {
                messagePrinter.errorMessage(e.getMessage());
            }
        } while (true);

        return gameStatus;
    }

    public List<Integer> getUserDigits() {
        List<Integer> userDigits;
        do {
            try {
                messagePrinter.inputNumberMessage();
                int userNumber = scanner.nextInt();
                userDigits = intToDigits(userNumber);

                validateLength(userDigits);
                validateDuplication(userDigits);

                break;
            } catch (Exception e) {
                messagePrinter.errorMessage(e.getMessage());
            }
        } while (true);
        return userDigits;
    }

    public List<Integer> getComputerDigits(Computer computer) {
        List<Integer> digits = computer.generateRandomDigits();
        messagePrinter.computerSelectionMessage();
        return digits;
    }

    public void call(String callString) {
        messagePrinter.judgeMessage(callString);
    }

    public void gameOver() {
        messagePrinter.userWinMessage();
        messagePrinter.gameOverMessage();
    }

    public void applicationOver() {
        messagePrinter.applicationOverMessage();
        System.exit(0);
    }

    private void validateLength(List<Integer> digits) throws InvalidLengthException {
        if (digits.size() != USER_DIGITS_SIZE) {
            throw new InvalidLengthException("3자리 숫자만 가능합니다.");
        }
    }

    private void validateDuplication(List<Integer> digits) throws InvalidNumberException {
        Set<Integer> digitSet = new HashSet<>(digits);
        if (digitSet.size() != USER_DIGITS_SIZE) {
            throw new InvalidNumberException("서로 다른 숫자만 가능합니다.");
        }
    }
}
