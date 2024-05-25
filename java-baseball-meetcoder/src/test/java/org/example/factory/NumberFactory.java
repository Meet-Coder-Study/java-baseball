package org.example.factory;

import java.util.ArrayList;
import java.util.List;
import org.example.domain.Number;

public class NumberFactory {

    public static List<Number> createNumberList(Integer... values) {
        List<Number> result = new ArrayList<>();
        for (Integer value: values) {
            Number number = new Number(value);
            result.add(number);
        }
        return result;
    }

}
