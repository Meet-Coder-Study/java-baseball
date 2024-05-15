package com.Domain;

import com.Entity.Record;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Computer {

    public static final int FIRST_NUMBER = 0;
    public static final int SECOND_NUMBER = 1;
    public static final int THIRD_NUMBER = 2;

    private final List<Integer> goal;

    public Computer() {
        List<Integer> seq = IntStream.range(1, 10)
                                     .boxed()
                                     .collect(Collectors.toList());
        Collections.shuffle(seq);
        this.goal = seq.subList(0, 3);
    }

    public Record checkAnswer(List<Integer> userNums) {
        int strike = checkStrikes(userNums);
        int ball = checkBalls(userNums, strike);

        return new Record(strike, ball);
    }

    public int checkStrikes(List<Integer> userNums) {
        int strikeCnt = 0;

        if(goal.get(FIRST_NUMBER).equals(userNums.get(FIRST_NUMBER))) strikeCnt++;
        if(goal.get(SECOND_NUMBER).equals(userNums.get(SECOND_NUMBER))) strikeCnt++;
        if(goal.get(THIRD_NUMBER).equals(userNums.get(THIRD_NUMBER))) strikeCnt++;

        return strikeCnt;
    }

    public int checkBalls(List<Integer> userNums, int strikeCnt) {
        int ballCnt = 0;

        for(Integer userNum : userNums) {
            if(goal.contains(userNum)) {
                ballCnt++;
            }
        }

        return ballCnt -= strikeCnt;
    }

    @Override
    public String toString() {
        return "[ANSWER = " + goal.get(FIRST_NUMBER) + "" + goal.get(SECOND_NUMBER) + "" + goal.get(THIRD_NUMBER) + "]";
    }
}