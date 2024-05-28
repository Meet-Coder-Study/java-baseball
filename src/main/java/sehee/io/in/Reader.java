package sehee.io.in;

import java.io.IOException;

public interface Reader {

    int readOneNumber() throws IOException;

    int[] readNumbers() throws IOException;

}
