package org.example.application.service;


import java.util.ArrayList;
import java.util.List;
import org.example.application.port.in.InputNumberUsecase;
import org.example.domain.UserInput;

public class InputNumberService implements InputNumberUsecase {

    @Override
    public UserInput generate(final String input) {
        List<Integer> values = new ArrayList<>();
        char[] chs = input.toCharArray();
        for (char ch : chs) {
            UserInput.checkValidChar(ch);
            Integer value = Character.getNumericValue(ch);
            values.add(value);
        }
        return new UserInput(values);
    }
}
