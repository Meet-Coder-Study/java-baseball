package sehee.io.in;

import static sehee.io.in.ReadConstant.ASCII_CODE_DECIMAL_NINE;
import static sehee.io.in.ReadConstant.ASCII_CODE_DECIMAL_ONE;
import static sehee.io.in.ReadConstant.CHAR_ZERO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CliReader implements Reader {

    private final BufferedReader cliReader;

    public CliReader() {
        cliReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int readOneNumber() throws IOException {
        char[] inputs = getStringInput().toCharArray();
        if (inputs.length > 1) {
            throw new IllegalArgumentException("1자리 숫자만 입력해주세요.");
        }

        return convertCharToInt(inputs[0]);
    }

    @Override
    public int[] readNumbers() throws IOException {
        char[] inputs = getStringInput().toCharArray();
        int[] numbers = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            numbers[i] = convertCharToInt(inputs[i]);
        }

        return numbers;
    }

    private String getStringInput() throws IOException {
        return cliReader.readLine();
    }

    private int convertCharToInt(char inputs) {
        checkIsNumber(inputs);
        return inputs - CHAR_ZERO;
    }

    private void checkIsNumber(char character) {
        if (character < ASCII_CODE_DECIMAL_ONE || ASCII_CODE_DECIMAL_NINE < character) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }

}
