package baseball.view;

import baseball.dto.CheckBallResponse;

public class OutputView {

    private OutputView() {
    }

    public static void printExitMessage() {
        System.out.println("애플리케이션이 종료되었습니다.");
    }

    public static void printResult(final CheckBallResponse checkBallResponse) {
        if (checkBallResponse.isNotting()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(checkBallResponse.ballCount() + "볼 " + checkBallResponse.strikeCount() + "스트라이크");

        if (checkBallResponse.isSuccess()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다.");
            System.out.println("-------게임 종료-------");
        }
    }

    public static void printPickComputerNumbers() {
        System.out.println("컴퓨터가 숫자를 뽑았습니다.");
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
