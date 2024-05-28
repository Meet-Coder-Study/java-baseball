package sehee.game.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static sehee.util.constant.GamePlayerMessage.OFF_MESSAGE;
import static sehee.util.constant.NumberBaseballGameConstant.END_NUMBER;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sehee.exception.ExceptionHandler;
import sehee.testutil.stub.GameStub;
import sehee.testutil.stub.PrinterStub;
import sehee.testutil.stub.ReaderStub;

class GamePlayerTest {

    private GamePlayer gamePlayer;
    private ReaderStub reader;
    private PrinterStub printer;

    @BeforeEach
    void setup() {
        // IO
        reader = new ReaderStub();
        printer = new PrinterStub();

        // Exception
        ExceptionHandler exceptionHandler = new ExceptionHandler(printer);

        // Set Game
        GameStub game = new GameStub(printer);

        // Play Game!
        gamePlayer = new GamePlayer(reader, printer, game, exceptionHandler);
    }

    @Test
    @DisplayName("GamePlayer를 시작하고 " + END_NUMBER + "를 누르면 게임을 정상적으로 종료할 수 있다.")
    void successOff() {
        // given
        reader.setOneNumber(END_NUMBER); // 사용자 입력값 종료로 설정

        // when
        ThrowableAssert.ThrowingCallable on = () -> gamePlayer.on();

        // then
        assertThatNoException().isThrownBy(on);
        assertThat(printer.getLatestMessage()).isEqualTo(OFF_MESSAGE);
    }

}
