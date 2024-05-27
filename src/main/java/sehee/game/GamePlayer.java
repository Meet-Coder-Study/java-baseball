package sehee.game;

import java.io.IOException;
import sehee.exception.ExceptionHandler;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public record GamePlayer(Reader reader, Printer printer, Game game, ExceptionHandler exceptionHandler) {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public void on() {
        while (true) {
            try {
                if (stopGame()) {
                    break;
                }

                game.play();
            } catch (Exception exception) {
                exceptionHandler.alert(exception);
            }
        }

        printer.println("애플리케이션이 종료되었습니다.");
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
