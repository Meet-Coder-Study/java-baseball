package org.example.adapter.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.example.application.port.in.InputHandler;

public class InputView implements InputHandler {

    private final BufferedReader bufferedReader;

    public InputView() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("입력에 실패했습니다.");
        }
    }
}
