package com.Domain;

public class Command {

    public static final String START = "1";
    public static final String END = "9";

    public static boolean isEndApplication(String command) {
        return command.equals(END);
    }

    public static boolean isValidInput(String command) {
        return !command.equals(START) && !command.equals(END);
    }
}
