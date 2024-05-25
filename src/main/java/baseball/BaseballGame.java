package baseball;

import baseball.domain.Computer;
import baseball.presentation.GameManager;
import baseball.domain.Referee;
import baseball.presentation.MessagePrinter;

import java.util.List;

public class BaseballGame {

    private static final Computer computer = new Computer();
    private static final Referee referee = new Referee();
    private static final GameManager gameManager = new GameManager(new MessagePrinter());

    public static void launch() {

        boolean isApplicationOver = false;
        while (!isApplicationOver) {
            int userCommand = gameManager.init();

            if (userCommand == 1) {
                List<Integer> computerDigits = gameManager.getComputerDigits(computer);
                referee.keepComputerDigits(computerDigits);
            } else if (userCommand == 9) {
                gameManager.applicationOver();
            }

            boolean isOut = false;
            while (!isOut) {
                List<Integer> userDigits = gameManager.getUserDigits();
                isOut = referee.judge(userDigits);
                String callMessage = referee.getCallMessage();
                gameManager.call(callMessage);
            }

            gameManager.gameOver();
        }
    }
}
