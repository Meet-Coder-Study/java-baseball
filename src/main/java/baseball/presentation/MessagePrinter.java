package baseball.presentation;

public class MessagePrinter {

    public void initMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");
    }

    public void computerSelectionMessage() {
        System.out.println("컴퓨터가 숫자를 뽑았습니다.");
    }

    public void inputNumberMessage() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public void userWinMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다.\n");
    }

    public void gameOverMessage() {
        System.out.println("-------게임 종료-------\n");
    }

    public void applicationOverMessage() {
        System.out.println("애플리케이션이 종료되었습니다.");
    }

    public void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void judgeMessage(String callString) {
        System.out.println(callString);
    }
}
