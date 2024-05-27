package org.example.application.service;


import java.util.ArrayList;
import java.util.List;
import org.example.application.port.in.UserInputUsecase;
import org.example.domain.Number;
import org.example.domain.UserInput;

public class UserInputService implements UserInputUsecase {

    @Override
    public UserInput generate(final String input) {
        List<Number> values = new ArrayList<>();
        char[] chs = input.toCharArray();
        for (char ch : chs) {
            UserInput.checkValidChar(ch);
            Integer value = Character.getNumericValue(ch);
            Number number = new Number(value);
            values.add(number);
        }
        return new UserInput(values);
    }
}
