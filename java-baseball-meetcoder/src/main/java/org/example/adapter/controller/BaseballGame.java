package org.example.adapter.controller;

import org.example.adapter.enums.Menu;
import org.example.application.port.in.AnswerUsecase;
import org.example.application.port.in.InputHandler;
import org.example.application.port.in.UserInputUsecase;
import org.example.application.port.in.ResultUsecase;
import org.example.application.port.in.SystemMessageHandler;
import org.example.domain.Answer;
import org.example.domain.UserInput;
import org.example.domain.Result;

public class BaseballGame {

    private final InputHandler inputHandler;
    private final SystemMessageHandler systemMessageHandler;
    private final AnswerUsecase answerUsecase;
    private final UserInputUsecase userInputUsecase;
    private final ResultUsecase resultUsecase;

    public BaseballGame(
        final InputHandler inputHandler,
        final SystemMessageHandler systemMessageHandler,
        final AnswerUsecase answerUsecase,
        final UserInputUsecase userInputUsecase,
        final ResultUsecase resultUsecase
    ) {
        this.inputHandler = inputHandler;
        this.systemMessageHandler = systemMessageHandler;
        this.answerUsecase = answerUsecase;
        this.userInputUsecase = userInputUsecase;
        this.resultUsecase = resultUsecase;
    }

    public void start() {
        String command;
        do {
            systemMessageHandler.printMenu();
            command = inputHandler.read();
            checkCommand(command);
        } while (Menu.isNotQuit(command));
        end();
    }

    private void end() {
        systemMessageHandler.printExitMessage();
        System.exit(0);
    }

    private void checkCommand(final String command) {
        Menu requestMenu = Menu.from(command);
        if (requestMenu.equals(Menu.START)) {
            process();
        }
    }

    private void process() {
        Answer answer = answerUsecase.generate();
        systemMessageHandler.printStartMessage();
        userTry(answer);
        systemMessageHandler.printAnswerMessage();
    }

    private void userTry(final Answer answer) {
        Result result;
        do {
            systemMessageHandler.printInputMessage();
            String input = inputHandler.read();
            UserInput userInput = userInputUsecase.generate(input);
            result = resultUsecase.check(answer, userInput);
            systemMessageHandler.printResult(result);
        } while (!result.isThreeStrike());
    }

}
