package sehee.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static sehee.util.constant.NumberBaseballGameMessage.GAME_OVER_MESSAGE;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sehee.answer.AnswerFactory;
import sehee.exception.ExceptionHandler;
import sehee.stub.NumberMakerStub;
import sehee.stub.PrinterStub;
import sehee.stub.ReaderStub;

class NumberBaseballGameTest {

    private NumberBaseballGame game;
    private ReaderStub reader;
    private PrinterStub printer;
    private NumberMakerStub numberMaker;

    @BeforeEach
    void setup() {
        // IO
        reader = new ReaderStub();
        printer = new PrinterStub();

        // Exception
        ExceptionHandler exceptionHandler = new ExceptionHandler(printer);

        // Set Game
        numberMaker = new NumberMakerStub();
        AnswerFactory answerFactory = new AnswerFactory(numberMaker);
        game = new NumberBaseballGame(reader, printer, answerFactory, exceptionHandler);
    }

    @Test
    @DisplayName("숫자 야구 게임을 시작하고 컴퓨터 설정값과 입력값이 일치하는 경우 정상적으로 종료된다.")
    void successGameOver() {
        // given
        int[] answerNumber = new int[] {1, 2, 3};
        numberMaker.setNumbers(answerNumber); // 컴퓨터 설정값
        reader.setNumbers(answerNumber); // 사용자 입력값

        // when
        ThrowableAssert.ThrowingCallable gameOver = () -> game.play();

        // then
        assertThatNoException().isThrownBy(gameOver);
        assertThat(printer.getLatestMessage()).isEqualTo(GAME_OVER_MESSAGE);
    }

}
