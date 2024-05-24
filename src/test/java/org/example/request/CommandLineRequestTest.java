package org.example.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandLineRequestTest {

    @Test
    @DisplayName("사용자가 작성한 내용을 그대로 반환한다.")
    void getUsersWrites() {
        //given
        ClientRequest request = new CommandLineRequest();

        //when, then
        Assertions.assertDoesNotThrow(request::getWrite);
    }

}
