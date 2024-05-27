package sehee.exception;

import sehee.io.out.Printer;

public record ExceptionHandler(
    Printer printer
) {

    public void alert(Exception exception) {
        printer.println(exception.getMessage());
    }

}
