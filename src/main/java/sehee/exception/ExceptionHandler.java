package sehee.exception;

import java.io.IOException;
import sehee.io.out.Printer;

public final class ExceptionHandler {

    private final Printer printer;

    public ExceptionHandler(Printer printer) {
        this.printer = printer;
    }

    public void alert(Exception exception) {
        printer.println(exception.getClass());
    }

    public void alert(IOException exception) {
        printer.println(exception.getClass());
    }

    public void alert(NumberFormatException exception) {
        printer.println("숫자 형식이 맞지 않습니다.");
    }

}
