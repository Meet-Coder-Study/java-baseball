package sehee;

import java.util.Random;
import sehee.answer.AnswerFactory;
import sehee.exception.ExceptionHandler;
import sehee.game.Game;
import sehee.game.RandomNumberGame;
import sehee.game.player.GamePlayer;
import sehee.io.in.CliReader;
import sehee.io.in.Reader;
import sehee.io.out.CliPrinter;
import sehee.io.out.Printer;
import sehee.util.numbermaker.NumberMaker;
import sehee.util.numbermaker.RandomNumberMaker;

public class GameContainer {

    public static void main(String[] args) {
        // IO
        Reader reader = new CliReader();
        Printer printer = new CliPrinter();

        // Exception
        ExceptionHandler exceptionHandler = new ExceptionHandler(printer);

        // Set Game
        NumberMaker numberMaker = new RandomNumberMaker(new Random());
        AnswerFactory answerFactory = new AnswerFactory(numberMaker);
        Game game = new RandomNumberGame(reader, printer, answerFactory, exceptionHandler);

        // Play Game!
        GamePlayer gamePlayer = new GamePlayer(reader, printer, game, exceptionHandler);
        gamePlayer.on();
    }

}
