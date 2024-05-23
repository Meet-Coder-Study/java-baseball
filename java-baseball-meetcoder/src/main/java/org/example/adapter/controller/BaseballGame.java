package org.example.adapter.controller;

import org.example.application.port.in.AnswerUsecase;
import org.example.application.port.in.InputNumberUsecase;
import org.example.application.port.in.ResultUsecase;
import org.example.application.port.in.InputHandler;
import org.example.application.port.in.SystemMessageHandler;
import org.example.domain.Answer;
import org.example.domain.InputNumber;
import org.example.domain.Result;

public class BaseballGame {

    private final InputHandler inputHandler;
    private final SystemMessageHandler systemMessageHandler;
    private final AnswerUsecase answerUsecase;
    private final InputNumberUsecase inputNumberUsecase;
    private final ResultUsecase resultUsecase;

    public BaseballGame(
        final InputHandler inputHandler,
        final SystemMessageHandler systemMessageHandler,
        final AnswerUsecase answerUsecase,
        final InputNumberUsecase inputNumberUsecase,
        final ResultUsecase resultUsecase
    ) {
        this.inputHandler = inputHandler;
        this.systemMessageHandler = systemMessageHandler;
        this.answerUsecase = answerUsecase;
        this.inputNumberUsecase = inputNumberUsecase;
        this.resultUsecase = resultUsecase;
    }

    public void start() {
        String command;
        do {
            systemMessageHandler.printMenu();
            command = inputHandler.read();
            checkCommand(command);
        } while (!isQuitCommand(command));
        end();
    }

    private boolean isQuitCommand(final String command) {
        // FIXME: 메뉴도 클래스로 뽑는게 좋지 않을까?
        return command.equals("9");
    }

    private void end() {
        systemMessageHandler.printExitMessage();
        System.exit(0);
    }

    private void checkCommand(final String command) {
        // FIXME: 메뉴도 클래스로 뽑는게 좋지 않을까?
        if (command.equals("1")) {
            process();
        }
        // FIXME: Command 생성할 때 이미 예외를 검증했는데, 여기에 예외처리를 둘 필요가 있을까?
        throw new IllegalStateException("존재하지 않는 메뉴입니다.");
    }

    private void process() {
        Answer answer = answerUsecase.generate();
        systemMessageHandler.printStartMessage();
        systemMessageHandler.printInputMessage();
        String input = inputHandler.read();
        InputNumber inputNumber = inputNumberUsecase.generate(input);
        // 4. 입력값과 정답 비교
        Result result = resultUsecase.check(answer, inputNumber);
        // 5: 비교 결과를 힌트로 출력
        systemMessageHandler.printResult(result);
        // TODO: 5-1. 정답일 경우 : 정답 안내문 출력
    }

}
