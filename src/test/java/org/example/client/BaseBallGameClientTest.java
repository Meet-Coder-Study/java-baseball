package org.example.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.example.message.GameMessage;
import org.example.request.CommandLineRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallGameClientTest {

    private final InputStream reset = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final BaseBallGameClient client = new BaseBallGameClient(
        new RandomNumberGeneratorImpl(),
        new CommandLineRequest()
    );
    private ByteArrayInputStream testIn;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setIn(reset);
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("정상적으로 야구 게임을 세팅한다.")
    void setupSuccess() {
        //given
        String input = String.valueOf(1);
        provideInput(input);

        //when
        int gameNumber = client.setup();

        //then
        String actualOutput = outputStreamCaptor.toString().trim();
        assertThat(actualOutput).isEqualTo(GameMessage.GAME_START);
        assertThat(gameNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("정상적으로 야구 게임 종료 메시지를 전달한다.")
    void closeSuccess() {
        //given
        client.stop();

        //then
        String actualOutput = outputStreamCaptor.toString().trim();
        assertThat(actualOutput).isEqualTo(GameMessage.GAME_END);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
