package sehee.game;

import static sehee.util.constant.NumberBaseballGameMessage.ALL_STRIKE_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.COMPUTER_CHOOSE_NUMBERS_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.GAME_OVER_MESSAGE;
import static sehee.util.constant.NumberBaseballGameMessage.WRITE_NUMBERS_MESSAGE;

import java.io.IOException;
import sehee.answer.Answer;
import sehee.answer.AnswerFactory;
import sehee.answer.Hint;
import sehee.exception.ExceptionHandler;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class NumberBaseballGame implements Game {

    private final Reader reader;
    private final Printer printer;
    private final AnswerFactory answerFactory;
    private final ExceptionHandler exceptionHandler;

    public NumberBaseballGame(
        Reader reader,
        Printer printer,
        AnswerFactory answerFactory,
        ExceptionHandler exceptionHandler
    ) {
        this.reader = reader;
        this.printer = printer;
        this.answerFactory = answerFactory;
        this.exceptionHandler = exceptionHandler;
    }

    @Override
    public void play() throws IOException {
        Answer answer = setComputerAnswer();
        boolean playing = true;
        while (playing) {
            playing = checkPlaying(answer);
        }

        gameOver();
    }

    private boolean checkPlaying(Answer answer) throws IOException {
        try {
            Answer userAnswer = readUserAnswer();
            Hint hint = answer.match(userAnswer);
            printer.println(hint);

            return !checkThreeStrike(hint);
        } catch (IllegalArgumentException e) {
            exceptionHandler.alert(e);

            return true;
        }
    }

    private boolean checkThreeStrike(Hint hint) {
        if (!hint.isThreeStrike()) {
            return false;
        }

        printer.println(ALL_STRIKE_MESSAGE);

        return true;

    }

    private Answer readUserAnswer() throws IOException {
        printer.print(WRITE_NUMBERS_MESSAGE);
        int[] userInputs = reader.readNumbers();

        return answerFactory.make(userInputs);
    }

    private Answer setComputerAnswer() {
        Answer answer = answerFactory.make();
        printer.println(COMPUTER_CHOOSE_NUMBERS_MESSAGE);

        return answer;
    }

    private void gameOver() {
        printer.println(GAME_OVER_MESSAGE);
    }

}
