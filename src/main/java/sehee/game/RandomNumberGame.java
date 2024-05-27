package sehee.game;

import java.io.IOException;
import sehee.domain.answer.Answer;
import sehee.domain.answer.AnswerFactory;
import sehee.domain.hint.Hint;
import sehee.domain.hint.HintProvider;
import sehee.io.in.Reader;
import sehee.io.out.Printer;

public class RandomNumberGame implements Game {

    private final Reader reader;
    private final Printer printer;
    private final AnswerFactory answerFactory;
    private final HintProvider answerMatcher;

    public RandomNumberGame(
        Reader reader,
        Printer printer,
        AnswerFactory answerFactory,
        HintProvider answerMatcher
    ) {
        this.reader = reader;
        this.printer = printer;
        this.answerFactory = answerFactory;
        this.answerMatcher = answerMatcher;
    }

    @Override
    public void play() throws IOException {
        Answer answer = setComputerAnswer();
        while (true) {
            Hint hint = answerMatcher.getHintFrom(answer, readUserAnswer());
            printer.println(hint);

            if (checkIsThreeStrike(hint)) {
                break;
            }
        }

        gameOver();
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

    private boolean checkIsThreeStrike(Hint hint) {
        if (hint.isThreeStrike()) {
            printer.println("3개의 숫자를 모두 맞히셨습니다.");

            return true;
        }

        return false;
    }


    private void gameOver() {
        printer.println("-------게임 종료-------");
    }

}
