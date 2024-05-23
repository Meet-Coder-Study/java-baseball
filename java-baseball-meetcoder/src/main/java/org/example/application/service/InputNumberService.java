package org.example.application.service;


import java.util.ArrayList;
import java.util.List;
import org.example.application.port.in.InputNumberUsecase;
import org.example.domain.InputNumber;

public class InputNumberService implements InputNumberUsecase {

    @Override
    public InputNumber generate(final String input) {
        List<Integer> values = new ArrayList<>();
        char[] chs = input.toCharArray();
        for (char ch : chs) {
            InputNumber.checkValidChar(ch);
            Integer value = Character.getNumericValue(ch);
            values.add(value);
        }
        return new InputNumber(values);
    }
}
