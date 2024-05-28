package sehee.game.player;

import static sehee.util.constant.GamePlayerMessage.CHOOSE_START_OR_END_EXCEPTION_MESSAGE;
import static sehee.util.constant.GamePlayerMessage.CHOOSE_START_OR_END_MESSAGE;
import static sehee.util.constant.GamePlayerMessage.OFF_MESSAGE;
import static sehee.util.constant.NumberBaseballGameConstant.END_NUMBER;
import static sehee.util.constant.NumberBaseballGameConstant.START_NUMBER;

import java.io.IOException;
import sehee.exception.ExceptionHandler;
import sehee.game.Game;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public record GamePlayer(
    Reader reader,
    Printer printer,
    Game game,
    ExceptionHandler exceptionHandler
) {

    public void on() {
        boolean working = true;
        while (working) {
            working = checkWorkingAndPlayGame();
        }
        printer.println(OFF_MESSAGE);
    }

    private boolean checkWorkingAndPlayGame() {
        try {
            if (checkStopGame()) {
                return false;
            }

            game.play();
        } catch (Exception exception) {
            exceptionHandler.alert(exception);
        }

        return true;
    }

    private boolean checkStopGame() throws IOException {
        printer.println(CHOOSE_START_OR_END_MESSAGE);

        int flag = reader.readOneNumber();
        switch (flag) {
            case START_NUMBER -> {
                return false;
            }
            case END_NUMBER -> {
                return true;
            }
        }

        throw new IllegalArgumentException(CHOOSE_START_OR_END_EXCEPTION_MESSAGE);
    }

}
