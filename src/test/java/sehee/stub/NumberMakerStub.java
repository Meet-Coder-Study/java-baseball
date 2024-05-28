package sehee.stub;

import sehee.util.numbermaker.NumberMaker;

public class NumberMakerStub implements NumberMaker {

    private int number;
    private int[] numbers;

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int make() {
        return number;
    }

    @Override
    public int[] makeAllUnique() {
        return numbers;
    }

}
