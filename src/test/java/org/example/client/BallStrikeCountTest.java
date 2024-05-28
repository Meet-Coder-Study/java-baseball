package org.example.client;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import org.example.message.GameMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallStrikeCountTest {

    private static final int ZERO_COUNT = 0;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("스트라이크만 있을 경우 스트라이크 정보만 출력한다.")
    void printStrikeInfo() {
        //given
        int strikeCount = new Random().nextInt(2) + 1;
        BallStrikeCount ballStrikeCount = new BallStrikeCount(strikeCount, ZERO_COUNT);
        String expectedResponse = strikeCount + GameMessage.STRIKE;

        //when, then
        ballStrikeCount.showBallStrikeCount();
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("전부 스트라이크인 경우 정답을 맞췄다는 메시지를 전달한다.")
    void printCorrectAllNumberInfo() {
        //given
        int strikeCount = 3;
        BallStrikeCount ballStrikeCount = new BallStrikeCount(strikeCount, ZERO_COUNT);
        String expectedResponse = strikeCount + GameMessage.STRIKE + "\n" + GameMessage.THREE_STRIKE;

        //when, then
        ballStrikeCount.showBallStrikeCount();
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("볼만 있을 경우 볼 정보만 출력한다.")
    void printBallInfo() {
        //given
        int ballCount = new Random().nextInt(3) + 1;
        BallStrikeCount ballStrikeCount = new BallStrikeCount(ZERO_COUNT, ballCount);
        String expectedResponse = ballCount + GameMessage.BALL;

        //when, then
        ballStrikeCount.showBallStrikeCount();
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("스트라이크도 볼도 없을 경우에는 맞추지 못했다는 메시지를 전달한다")
    void printNoCorrectAnswerInfo() {
        //given
        BallStrikeCount ballStrikeCount = new BallStrikeCount(ZERO_COUNT, ZERO_COUNT);
        String expectedResponse = GameMessage.NO_CORRECT_NUM;

        //when, then
        ballStrikeCount.showBallStrikeCount();
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("스트라이크와 볼 모두 있는 경우 맞춘 숫자만큼 출력한다.")
    void printStrikeAndBallInfo() {
        //given
        int strikeCount = new Random().nextInt(2) + 1;
        int ballCount = 3 - strikeCount;

        BallStrikeCount ballStrikeCount = new BallStrikeCount(strikeCount, ballCount);
        String expectedResponse = ballCount + GameMessage.BALL + " " + strikeCount + GameMessage.STRIKE;

        //when, then
        ballStrikeCount.showBallStrikeCount();
        String actualOutput = outputStreamCaptor.toString().trim();

        assertThat(actualOutput).isEqualTo(expectedResponse);
    }

}
