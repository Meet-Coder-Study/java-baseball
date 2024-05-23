package meetcoder.study.view;

import static meetcoder.study.view.ConsoleMessage.CLEAR_MESSAGE;
import static meetcoder.study.view.ConsoleMessage.COMMAND_DESCRIPTION;
import static meetcoder.study.view.ConsoleMessage.END_MESSAGE;
import static meetcoder.study.view.ConsoleMessage.GOOD_BYE_MESSAGE;
import static meetcoder.study.view.ConsoleMessage.NUMBER_INPUT_MESSAGE;
import static meetcoder.study.view.ConsoleMessage.SETUP_MESSAGE;

import meetcoder.study.model.BaseballGuessResult;

public class ConsoleOutputView {

    public void displayManual() {
        println(COMMAND_DESCRIPTION);
    }

    public void displayError(Exception ex) {
        println("⚠️" + ex.getMessage());
    }

    public void displayGoodbyeMessage() {
        emptyLine();
        println(GOOD_BYE_MESSAGE);
    }

    public void displaySetUpComplete() {
        emptyLine();
        println(SETUP_MESSAGE);
        emptyLine();
    }

    public void displayNumberInputRequest() {
        print(NUMBER_INPUT_MESSAGE + " : ");
    }

    public void displayGameOver() {
        emptyLine();
        println(CLEAR_MESSAGE);
        printWithDashLine(END_MESSAGE);
        emptyLine();
    }

    public void printBaseballResult(BaseballGuessResult result) {
        println(result.summary());
    }

    private void println(String message) {
        System.out.println(message);
    }

    private void print(String message) {
        System.out.print(message);
    }

    public void printWithDashLine(String message) {
        System.out.println("-------" + message + "-------");
    }

    private void emptyLine() {
        System.out.println();
    }

}
