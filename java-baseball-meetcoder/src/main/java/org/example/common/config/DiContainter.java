package org.example.common.config;

import org.example.adapter.controller.BaseballGame;
import org.example.adapter.view.InputView;
import org.example.adapter.view.SystemMessagePrinter;
import org.example.application.port.in.AnswerUsecase;
import org.example.application.port.in.UserInputUsecase;
import org.example.application.port.in.ResultUsecase;
import org.example.application.port.in.InputHandler;
import org.example.application.port.in.SystemMessageHandler;
import org.example.application.service.AnswerService;
import org.example.application.service.UserInputService;
import org.example.application.service.ResultService;

public class DiContainter {

    private DiContainter() {
        throw new IllegalCallerException("can't initialize DiContainer");
    }

    private static final BaseballGame BASEBALL_GAME;
    private static final InputHandler INPUT_HANDLER;
    private static final SystemMessageHandler SYSTEM_MESSAGE_HANDLER;
    private static final AnswerUsecase ANSWER_USECASE;
    private static final UserInputUsecase USER_INPUT_USECASE;
    private static final ResultUsecase CHECK_USECASE;

    static {
        INPUT_HANDLER = new InputView();
        SYSTEM_MESSAGE_HANDLER = new SystemMessagePrinter();
        ANSWER_USECASE = new AnswerService();
        USER_INPUT_USECASE = new UserInputService();
        CHECK_USECASE = new ResultService();
        BASEBALL_GAME = new BaseballGame(
            INPUT_HANDLER,
            SYSTEM_MESSAGE_HANDLER,
            ANSWER_USECASE,
            USER_INPUT_USECASE,
            CHECK_USECASE
        );
    }

    public static BaseballGame loadGame() {
        return BASEBALL_GAME;
    }

}
