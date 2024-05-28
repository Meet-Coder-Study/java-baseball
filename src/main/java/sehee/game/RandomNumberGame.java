package sehee.game;

import java.io.IOException;
import sehee.domain.Answer;
import sehee.domain.AnswerFactory;
import sehee.domain.Hint;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class RandomNumberGame implements Game {

    private final Reader reader;
    private final Printer printer;
    private final AnswerFactory answerFactory;

    public RandomNumberGame(
        Reader reader,
        Printer printer,
        AnswerFactory answerFactory
    ) {
        this.reader = reader;
        this.printer = printer;
        this.answerFactory = answerFactory;
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
            printer.println("숫자 입력값이 올바르지 않아 진행할 수 없습니다.");

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
        printer.print("숫자를 입력해주세요:");
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
