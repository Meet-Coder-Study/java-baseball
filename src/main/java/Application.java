import Domain.Computer;
import Domain.User;
import Entity.Record;
import Enums.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static final String START = "1";
    public static final String END = "9";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(Boolean.TRUE) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");

                String inp = br.readLine();

                if(inp.equals(END)) {
                    System.out.println("어플리케이션이 종료되었습니다.");
                    break;
                }

                if(!inp.equals(START)) {
                    continue;
                }

                run();
            }
        } catch (Exception e) {

        } finally {
            br.close();
        }
    }

    public static void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Computer computer = new Computer();
            System.out.println("컴퓨터가 숫자를 뽑았습니다.");
            System.out.println(computer);

            while(Boolean.TRUE) {
                System.out.print("숫자를 입력해주세요, : ");
                User user = new User(br.readLine());

                Record result = computer.checkAnswer(user.getuserNums());
                result.printResult();

                if(Game.END.equals(result.getResult())) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다.");
                    System.out.println("-------게임 종료-------");
                    break;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");

            if(br.readLine().equals(START)){
                run();
            }

        } catch (Exception e) {

        } finally {
            br.close();
        }
    }
}