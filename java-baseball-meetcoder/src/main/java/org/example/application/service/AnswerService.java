package org.example.application.service;

import static org.example.domain.Answer.LENGTH;
import static org.example.domain.Answer.START_INDEX;
import static org.example.domain.Number.MAX_NUMBER;
import static org.example.domain.Number.MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.application.port.in.AnswerUsecase;
import org.example.domain.Answer;
import org.example.domain.Number;

public class AnswerService implements AnswerUsecase {

    @Override
    public Answer generate() {
        List<Number> list = makeList();
        Collections.shuffle(list);
        List<Number> subList = list.subList(START_INDEX, LENGTH);
        List<Number> values = List.copyOf(subList);
        return new Answer(values);
    }

    private List<Number> makeList() {
        List<Number> list = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            Number number = new Number(i);
            list.add(number);
        }
        return list;
    }
}
