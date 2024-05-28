package sehee.game;

import java.io.IOException;
import sehee.answer.Answer;
import sehee.answer.AnswerFactory;
import sehee.answer.Hint;
import sehee.exception.ExceptionHandler;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class RandomNumberGame implements Game {

    private final Reader reader;
    private final Printer printer;
    private final AnswerFactory answerFactory;
    private final ExceptionHandler exceptionHandler;

    public RandomNumberGame(
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

        printer.println("3개의 숫자를 모두 맞히셨습니다.");

        return true;

    }

    private Answer readUserAnswer() throws IOException {
        printer.print("숫자를 입력해주세요: ");
        int[] userInputs = reader.readNumbers();

        return answerFactory.make(userInputs);
    }

    private Answer setComputerAnswer() {
        Answer answer = answerFactory.make();
        printer.println("컴퓨터가 숫자를 뽑았습니다.");

        return answer;
    }

    private void gameOver() {
        printer.println("-------게임 종료-------");
    }

}
