package org.example.request;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;
import org.example.message.BaseBallErrorMessage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandLineRequestTest {

    private final InputStream reset = System.in;
    private final ClientRequest request = new CommandLineRequest();
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private ByteArrayInputStream testIn;
    private Random random = new Random();


    @AfterEach
    public void tearDown() {
        System.setIn(reset);
    }

    @Test
    @DisplayName("사용자가 작성한 내용을 그대로 반환한다.")
    void getUsersWrites() {
        //given
        String input = "test input";
        provideInput(input);

        //when
        String writtenInput = request.getWrite();

        //then
        assertThat(input).isEqualTo(writtenInput);
    }

    @Test
    @DisplayName("숫자 입력 메서드를 이용할 경우 숫자를 입력하면 정상적으로 입력된다.")
    void getUsersNumberWrites() {
        //given
        String input = String.valueOf(random.nextInt(10000));
        provideInput(input);

        //when
        int writtenNumberInput = request.getNumber();

        //then
        assertThat(Integer.valueOf(input)).isEqualTo(writtenNumberInput);
    }

    @Test
    @DisplayName("숫자가 아닌 내용을 숫자입력 메서드에 입력할 경우 다시 입력해야 한다.")
    void getUsersInvalidNumberWrites() {
        //given
        String actualOutput = outputStreamCaptor.toString().trim();
        StringBuilder sb = new StringBuilder();
        String input = String.valueOf(random.nextInt(10000));
        String wrongInput = sb.append("abc")
            .append("\n")
            .append(input)
            .toString();
        provideInput(wrongInput);

        //when
        int writtenNumberInput = request.getNumber();

        //then
        assertThat(actualOutput).isEqualTo(BaseBallErrorMessage.NON_NUMBER_INPUT_ERROR);
        assertThat(Integer.valueOf(input)).isEqualTo(writtenNumberInput);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
}
