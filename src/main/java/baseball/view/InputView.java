package baseball.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_DELIMITER = "";

    private InputView() {
    }

    public static int inputMenu() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        final String inputNumbers = scanner.next();

        return Arrays.stream(inputNumbers.split(INPUT_DELIMITER))
                .map(Integer::parseInt)
                .toList();
    }
}
