package org.example.application.port.in;

import org.example.domain.Result;

public interface SystemMessageHandler {

    void printMenu();
    void printStartMessage();
    void printInputMessage();
    void printResult(Result result);
    void printAnswerMessage();
    void printExitMessage();

}
