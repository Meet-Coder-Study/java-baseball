package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");
            int num = scanner.nextInt();
            if (num == 9) {
                System.out.println("애플리케이션이 종료되었습니다.");
                break;
            }
            if (num == 1) {
                Random random = new Random();
                int randomNum = random.nextInt(998) + 1;
                String baseBallNum = String.valueOf(randomNum);
                System.out.println("컴퓨터가 숫자를 뽑았습니다.");
                System.out.println();
                while (true) {
                    int strikeCount = 0;
                    int ballCount = 0;
                    System.out.print("숫자를 입력해주세요 : ");
                    String inputNum = scanner.next();

                    for (int i = 0; i < 3; i++) {
                        char comparingInput = inputNum.charAt(i);
                        for (int j = 0; j < 3; j++) {
                            if (i == j && comparingInput == baseBallNum.charAt(j)) {
                                strikeCount++;
                                continue;
                            }

                            if (comparingInput == baseBallNum.charAt(j)) {
                                ballCount++;
                            }
                        }
                    }
                    if (strikeCount == 3) {
                        System.out.println("3개의 숫자를 모두 맞히셨습니다.");
                        System.out.println("-------게임 종료-------");
                        break;
                    }
                    if (ballCount == 0 && strikeCount == 0) {
                        System.out.println("맞추신 숫자가 없습니다.");
                        continue;
                    }
                    if (ballCount > 0 && strikeCount == 0) {
                        System.out.println(ballCount + "볼");
                        continue;
                    }
                    if (ballCount == 0 && strikeCount > 0) {
                        System.out.println(strikeCount + "스트라이크");
                        continue;
                    }
                    if (ballCount > 0 && strikeCount > 0) {
                        System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
                    }
                }
            }
        }
    }

}
