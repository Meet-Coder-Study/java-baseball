package org.example.factory;

import java.util.List;
import org.example.domain.Number;
import org.example.domain.UserInput;

public class UserInputFactory {

    public static UserInput createUserInput(Integer... values) {
        List<Number> numbers = NumberFactory.createNumberList(values);
        return new UserInput(numbers);
    }

}
