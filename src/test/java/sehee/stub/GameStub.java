package sehee.stub;

import sehee.game.Game;

public class GameStub implements Game {

    public static final String PLAYING_GAME_MESSAGE = "Playing game!";

    private final PrinterStub printer;

    public GameStub(PrinterStub printer) {
        this.printer = printer;
    }

    @Override
    public void play() {
        this.printer.print(PLAYING_GAME_MESSAGE);
    }

}
