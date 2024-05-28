package sehee.testutil.stub;

import sehee.io.out.Printer;

public class PrinterStub implements Printer {

    private String latestMessage;

    public String getLatestMessage() {
        return latestMessage;
    }

    @Override
    public void print(String message) {
        latestMessage = message;
    }

    @Override
    public void println(String message) {
        latestMessage = message;
    }

    @Override
    public <T> void println(T object) {
        latestMessage = object.toString();
    }

}
