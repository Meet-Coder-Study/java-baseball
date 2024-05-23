package org.example.application.port.in;

import org.example.domain.Answer;
import org.example.domain.InputNumber;
import org.example.domain.Result;

public interface ResultUsecase {

    Result check(Answer answer, InputNumber inputNumber);

}
