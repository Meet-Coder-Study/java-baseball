package org.example.request;

import java.util.Scanner;

public class CommandLineRequest implements ClientRequest {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String getWrite(){
        return scanner.nextLine();
    }
}
