package sehee;

import sehee.domain.answer.AnswerFactory;
import sehee.domain.hint.HintProvider;
import sehee.exception.ExceptionHandler;
import sehee.game.Game;
import sehee.game.GamePlayer;
import sehee.game.RandomNumberGame;
import sehee.io.in.CliReader;
import sehee.io.in.Reader;
import sehee.io.out.CliPrinter;
import sehee.io.out.Printer;

public class Main {

    public static void main(String[] args) {
        // IO
        Reader reader = new CliReader();
        Printer printer = new CliPrinter();

        // Game
        AnswerFactory answerFactory = new AnswerFactory();
        HintProvider hintProvider = new HintProvider();
        Game game = new RandomNumberGame(reader, printer, answerFactory, hintProvider);

        // Exception
        ExceptionHandler exceptionHandler = new ExceptionHandler(printer);

        // Play Game
        GamePlayer gamePlayer = new GamePlayer(reader, printer, game, exceptionHandler);
        gamePlayer.on();
    }

}
