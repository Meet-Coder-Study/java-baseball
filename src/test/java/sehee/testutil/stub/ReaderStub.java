package sehee.testutil.stub;

import sehee.io.in.Reader;

public class ReaderStub implements Reader {

    private int oneNumber;

    private int[] numbers;

    public void setOneNumber(int oneNumber) {
        this.oneNumber = oneNumber;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public int readOneNumber() {
        return this.oneNumber;
    }

    @Override
    public int[] readNumbers() {
        return this.numbers;
    }

}
