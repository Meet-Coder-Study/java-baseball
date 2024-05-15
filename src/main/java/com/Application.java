package com;

import com.Domain.Command;
import com.Domain.Computer;
import com.Domain.User;
import com.Entity.Record;
import com.Enums.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            while(Boolean.TRUE) {
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.");

                String userInput = br.readLine();

                if(Command.isEndApplication(userInput)) {
                    System.out.println("어플리케이션이 종료되었습니다.");
                    break;
                }

                if(Command.isValidInput(userInput)) {
                    System.out.println("1 또는 9만 입력 가능합니다.");
                    continue;
                }

                run(br);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        br.close();
    }

    public static void run(BufferedReader br) throws IOException {
        try {
            Computer computer = new Computer();
            System.out.println("컴퓨터가 숫자를 뽑았습니다. " + computer);

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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}