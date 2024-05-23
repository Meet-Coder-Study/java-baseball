package org.example.common.config;

import org.example.adapter.controller.BaseballGame;
import org.example.adapter.view.InputView;
import org.example.adapter.view.SystemMessagePrinter;
import org.example.application.port.in.InputHandler;
import org.example.application.port.in.SystemMessageHandler;

public class DiContainter {

    private DiContainter() {
        throw new IllegalCallerException("can't initialize DiContainer");
    }

    private static final BaseballGame BASEBALL_GAME;
    private static final InputHandler INPUT_HANDLER;
    private static final SystemMessageHandler SYSTEM_MESSAGE_HANDLER;

    static {
        INPUT_HANDLER = new InputView();
        SYSTEM_MESSAGE_HANDLER = new SystemMessagePrinter();
        BASEBALL_GAME = new BaseballGame(INPUT_HANDLER, SYSTEM_MESSAGE_HANDLER);
    }

    public static BaseballGame loadGame() {
        return BASEBALL_GAME;
    }

}
