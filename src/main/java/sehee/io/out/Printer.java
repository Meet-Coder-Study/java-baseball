package sehee.io.out;

public interface Printer {

    void print(Integer message);

    void print(String message);

    void println(Integer message);

    void println(String message);

    <T> void println(T object);

}
