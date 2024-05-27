package sehee;

import java.util.Random;
import sehee.domain.answer.AnswerFactory;
import sehee.domain.hint.HintMaker;
import sehee.exception.ExceptionHandler;
import sehee.game.Game;
import sehee.game.GamePlayer;
import sehee.game.RandomNumberGame;
import sehee.io.in.CliReader;
import sehee.io.in.Reader;
import sehee.io.out.CliPrinter;
import sehee.io.out.Printer;
import sehee.util.NumberMaker;

public class Main {

    public static void main(String[] args) {
        // IO
        Reader reader = new CliReader();
        Printer printer = new CliPrinter();

        // Game
        NumberMaker numberMaker = new NumberMaker(new Random());
        AnswerFactory answerFactory = new AnswerFactory(numberMaker);
        HintMaker hintProvider = new HintMaker();
        Game game = new RandomNumberGame(reader, printer, answerFactory, hintProvider);

        // Exception
        ExceptionHandler exceptionHandler = new ExceptionHandler(printer);

        // Play Game
        GamePlayer gamePlayer = new GamePlayer(reader, printer, game, exceptionHandler);
        gamePlayer.on();
    }

}
