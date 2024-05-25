package org.example.application.port.in;

import org.example.domain.AnswerNumber;
import org.example.domain.InputNumber;
import org.example.domain.Result;

public interface ResultUsecase {

    Result check(AnswerNumber answerNumber, InputNumber inputNumber);

}
