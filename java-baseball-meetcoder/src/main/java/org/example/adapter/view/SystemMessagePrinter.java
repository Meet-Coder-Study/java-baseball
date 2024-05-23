package org.example.adapter.view;

import org.example.application.port.in.SystemMessageHandler;
import org.example.domain.Result;

public class SystemMessagePrinter implements SystemMessageHandler {

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
        System.out.println("숫자를 입력해주세요 : ");
    }

    @Override
    public void printResult(final Result result) {
        // TODO: 정답과 입력값을 비교한 결과를 전달받아서 출력할 것
        System.out.println();
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
