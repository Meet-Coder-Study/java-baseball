package sehee.io.out;

import static sehee.io.out.PrintConstant.LINE_SEPARATOR;

import java.io.PrintStream;

public class CliPrinter implements Printer {

    private final PrintStream cliPrinter;

    public CliPrinter() {
        cliPrinter = System.out;
    }

    @Override
    public void print(String message) {
        cliPrinter.print(message);
    }

    @Override
    public void println(String message) {
        cliPrinter.print(message + LINE_SEPARATOR);
    }

    @Override
    public <T> void println(T object) {
        println(object.toString());
    }

}
