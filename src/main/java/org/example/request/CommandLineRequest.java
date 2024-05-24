package org.example.request;

import java.util.Scanner;
import org.example.message.BaseBallErrorMessage;

public class CommandLineRequest implements ClientRequest {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String getWrite(){
        return scanner.nextLine();
    }

    @Override
    public int getNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException e){
            System.out.println(BaseBallErrorMessage.NON_NUMBER_INPUT_ERROR);
            return getNumber();
        }
    }

}
