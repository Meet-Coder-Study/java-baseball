package org.example.adapter.controller;

import org.example.application.port.in.InputHandler;
import org.example.application.port.in.SystemMessageHandler;

public class BaseballGame {

    private final InputHandler inputHandler;
    private final SystemMessageHandler systemMessageHandler;

    public BaseballGame(
        final InputHandler inputHandler,
        final SystemMessageHandler systemMessageHandler
    ) {
        this.inputHandler = inputHandler;
        this.systemMessageHandler = systemMessageHandler;
    }

    public void start() {
        String command;
        do {
            systemMessageHandler.printMenu();
            command = inputHandler.read();
            process(command);
        } while (!isQuitCommand(command));
        end();
    }

    private boolean isQuitCommand(final String command) {
        return command.equals("9");
    }

    public void end() {
        systemMessageHandler.printExitMessage();
        System.exit(0);
    }

    public void process(final String command) {
        // TODO: 게임 프로세스 추가
    }

}
