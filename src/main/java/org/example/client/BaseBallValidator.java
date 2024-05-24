package org.example.client;

import java.util.Arrays;
import org.example.exception.BaseBallException;
import org.example.message.BaseBallErrorMessage;

public class BaseBallValidator {

    private static final int START_NUM = 1;
    private static final int END_NUM = 9;

    private BaseBallValidator(){}

    public static void gameStartEndNumberValidator(int number){
        if(number != START_NUM && number != END_NUM){
            throw new BaseBallException(BaseBallErrorMessage.INVALID_START_OR_END_NUMBER);
        }
    }

    public static void validateClientNumber(int clientNumber) {
        String stringClientNumber = String.valueOf(clientNumber);

        if(stringClientNumber.length() != 3) {
            throw new BaseBallException(BaseBallErrorMessage.INVALID_USER_NUMBER_GUESS);
        }

        long distinctCount = Arrays.stream(stringClientNumber.split(""))
            .distinct()
            .count();

        if(distinctCount !=3 ){
            throw new BaseBallException(BaseBallErrorMessage.INVALID_USER_NUMBER_GUESS);
        }
    }

}
