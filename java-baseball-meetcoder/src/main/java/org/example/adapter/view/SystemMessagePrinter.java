package org.example.adapter.view;

import org.example.application.port.in.SystemMessageHandler;
import org.example.domain.Result;

public class SystemMessagePrinter implements SystemMessageHandler {

    private static final String SPACE = " ";

    @Override
    public void printMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");
    }

    @Override
    public void printStartMessage() {
        System.out.println("컴퓨터가 숫자를 뽑았습니다.");
    }

    @Override
    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    @Override
    public void printResult(final Result result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        StringBuilder message = new StringBuilder();
        appendBall(result.ball, message);
        if (!message.isEmpty()) {
            message.append(SPACE);
        }
        appendStrike(result.strike, message);
        System.out.println(message);
    }

    private void appendBall(final int ball, StringBuilder message) {
        if (ball > Result.INIT_VALUE) {
            message.append(ball);
            message.append("볼");
        }
    }

    private void appendStrike(final int strike, StringBuilder message) {
        if (strike > Result.INIT_VALUE) {
            message.append(strike);
            message.append("스트라이크");
        }
    }

    @Override
    public void printAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다.");
        System.out.println("-------게임 종료-------");
    }

    @Override
    public void printExitMessage() {
        System.out.println("애플리케이션이 종료되었습니다.");
    }
}
