package org.example.application.port.in;

public interface SystemMessageHandler {

    void printMenu();
    void printStartMessage();
    void printInputMessage();
    void printHintMessage();
    void printAnswerMessage();
    void printExitMessage();

}
