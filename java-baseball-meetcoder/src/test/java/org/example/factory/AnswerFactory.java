package org.example.factory;

import java.util.List;
import org.example.domain.Answer;
import org.example.domain.Number;

public class AnswerFactory {

    public static Answer createAnswer(Integer... values) {
        List<Number> numbers = NumberFactory.createNumberList(values);
        return new Answer(numbers);
    }

}
