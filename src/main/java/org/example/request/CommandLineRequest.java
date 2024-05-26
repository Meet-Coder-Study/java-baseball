package org.example.request;

import java.util.Scanner;
import org.example.message.BaseBallErrorMessage;

public class CommandLineRequest implements ClientRequest {

    @Override
    public String getWrite(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    @Override
    public int getNumber() {
        try {
            Scanner scanner = new Scanner(System.in);
            int input = Integer.parseInt(scanner.nextLine());
            scanner.close();
            return input;
        } catch (RuntimeException e){
            System.out.println(BaseBallErrorMessage.NON_NUMBER_INPUT_ERROR);
            return getNumber();
        }
    }

}
