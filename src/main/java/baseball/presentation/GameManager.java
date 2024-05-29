package baseball.presentation;

import baseball.domain.Computer;
import baseball.common.exception.InvalidLengthException;
import baseball.common.exception.InvalidNumberException;
import baseball.presentation.input.InputProvider;

import java.util.*;

import static baseball.common.utils.converter.intToDigits;


public class GameManager {

    private static final int USER_DIGITS_SIZE = 3;

    private final MessagePrinter messagePrinter;
    private final InputProvider inputProvider;

    public GameManager(MessagePrinter messagePrinter, InputProvider inputProvider) {
        this.messagePrinter = messagePrinter;
        this.inputProvider = inputProvider;
    }

    public GameStatus init() {
        GameStatus gameStatus;
        do {
            try {
                messagePrinter.initMessage();
                String input = inputProvider.getInput();
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
                String input = inputProvider.getInput();
                int userNumber = Integer.parseInt(input);
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
            throw new InvalidLengthException(USER_DIGITS_SIZE);
        }
    }

    private void validateDuplication(List<Integer> digits) throws InvalidNumberException {
        Set<Integer> digitSet = new HashSet<>(digits);
        if (digitSet.size() != USER_DIGITS_SIZE) {
            throw new InvalidNumberException();
        }
    }
}
