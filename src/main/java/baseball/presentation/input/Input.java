package baseball.presentation.input;

import java.util.Scanner;

public class Input implements InputProvider {

    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
