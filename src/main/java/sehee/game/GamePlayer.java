package sehee.game;

import java.io.IOException;
import sehee.exception.ExceptionHandler;
import sehee.exception.FlagFormatException;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class GamePlayer {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;
    private static final String SELECT_FLAG_MESSAGE =
        "게임을 새로 시작하려면 " + START_NUMBER + ", 종료하려면 " + END_NUMBER + "를 입력하세요.";
    private static final String OFF_MESSAGE = "애플리케이션이 종료되었습니다.";

    private final Reader reader;
    private final Printer printer;
    private final Game game;
    private final ExceptionHandler exceptionHandler;

    public GamePlayer(Reader reader, Printer printer, Game game, ExceptionHandler exceptionHandler) {
        this.reader = reader;
        this.printer = printer;
        this.game = game;
        this.exceptionHandler = exceptionHandler;
    }

    public void on() {
        try {
            while (true) {
                try {
                    printer.println(SELECT_FLAG_MESSAGE);

                    if (!startNewGame()) {
                        break;
                    }
                    game.play();
                } catch (Exception exception) {
                    exceptionHandler.alert(exception);
                }
            }
        } catch (Exception exception) {
            exceptionHandler.alert(exception);
        }

        printer.println(OFF_MESSAGE);
    }

    private boolean startNewGame() throws IOException {
        int flag = reader.readOneNumber();
        switch (flag) {
            case START_NUMBER -> {
                return true;
            }
            case END_NUMBER -> {
                return false;
            }
        }

        throw new FlagFormatException("1(시작) 혹은 9(종료)를 입력해주세요.");
    }

}
