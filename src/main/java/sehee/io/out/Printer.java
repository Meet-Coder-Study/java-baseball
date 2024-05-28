package sehee.io.out;

public interface Printer {

    void print(String message);

    void println(String message);

    <T> void println(T object);

}
