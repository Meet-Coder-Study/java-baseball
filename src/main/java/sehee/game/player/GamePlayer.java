package sehee.game.player;

import static sehee.util.constant.RandomNumberGameConstant.END_NUMBER;
import static sehee.util.constant.RandomNumberGameConstant.START_NUMBER;

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
        printer.println("애플리케이션이 종료되었습니다.");
    }

    private boolean checkWorkingAndPlayGame() {
        try {
            if (stopGame()) {
                return false;
            }

            game.play();
        } catch (Exception exception) {
            exceptionHandler.alert(exception);
        }

        return true;
    }

    private boolean stopGame() throws IOException {
        printer.println("게임을 새로 시작하려면 " + START_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.");

        int flag = reader.readOneNumber();
        switch (flag) {
            case START_NUMBER -> {
                return false;
            }
            case END_NUMBER -> {
                return true;
            }
        }

        throw new IllegalArgumentException("1(시작) 혹은 9(종료)를 입력해주세요.");
    }

}
