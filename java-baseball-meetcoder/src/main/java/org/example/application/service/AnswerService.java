package org.example.application.service;

import static org.example.domain.Answer.LENGTH;
import static org.example.domain.Answer.MAX_NUMBER;
import static org.example.domain.Answer.MIN_NUMBER;
import static org.example.domain.Answer.START_INDEX;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.example.application.port.in.AnswerUsecase;
import org.example.domain.Answer;

public class AnswerService implements AnswerUsecase {

    @Override
    public Answer generate() {
        List<Integer> list = makeList();
        Collections.shuffle(list);
        List<Integer> subList = list.subList(START_INDEX, LENGTH);
        List<Integer> values = List.copyOf(subList);
        return new Answer(values);
    }

    private List<Integer> makeList() {
        List<Integer> list = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            list.add(i);
        }
        return list;
    }
}
