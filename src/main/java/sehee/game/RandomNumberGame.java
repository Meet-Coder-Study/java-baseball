package sehee.game;

import java.io.IOException;
import sehee.domain.answer.Answer;
import sehee.domain.answer.AnswerFactory;
import sehee.domain.hint.Hint;
import sehee.domain.hint.HintMaker;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class RandomNumberGame implements Game {

    private final Reader reader;
    private final Printer printer;
    private final AnswerFactory answerFactory;
    private final HintMaker hintMaker;

    public RandomNumberGame(
        Reader reader,
        Printer printer,
        AnswerFactory answerFactory,
        HintMaker hintMaker
    ) {
        this.reader = reader;
        this.printer = printer;
        this.answerFactory = answerFactory;
        this.hintMaker = hintMaker;
    }

    @Override
    public void play() throws IOException {
        Answer answer = setComputerAnswer();
        boolean playing = true;
        while (playing) {
            playing = isPlaying(answer);
        }

        gameOver();
    }

    private boolean isPlaying(Answer answer) throws IOException {
        try {
            Answer userAnswer = readUserAnswer();
            Hint hint = hintMaker.make(answer, userAnswer);
            printer.println(hint);

            return !checkThreeStrike(hint);
        } catch (IllegalArgumentException e) {
            printer.println("숫자 입력값이 올바르지 않아 진행할 수 없습니다.");

            return true;
        }
    }

    private boolean checkThreeStrike(Hint hint) {
        if (hint.isThreeStrike()) {
            printer.println("3개의 숫자를 모두 맞히셨습니다.");

            return true;
        }

        return false;
    }

    private Answer readUserAnswer() throws IOException {
        printer.print("숫자를 입력해주세요:");
        int[] userInputs = reader.readNumbers();

        return answerFactory.makeUserAnswer(userInputs);
    }

    private Answer setComputerAnswer() {
        Answer answer = answerFactory.makeRandomAnswer();
        printer.println("컴퓨터가 숫자를 뽑았습니다.");

        return answer;
    }


    private void gameOver() {
        printer.println("-------게임 종료-------");
    }

}
