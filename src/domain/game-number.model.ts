import { MAX_NUMBER, MIN_NUMBER, NUM_LENGTH } from '../const/num-range';
import { generateRandomNumberString } from '../util/number';

export class GameNumber {
    private readonly numbers: readonly number[] = [];

    private constructor(input: string) {
        const trimmedInput = input.replace(/\s/g, '');

        this.validateLength(trimmedInput);
        this.numbers = trimmedInput.split('').map((cur) => {
            const inputNumber = parseInt(cur);
            this.validateType(inputNumber);
            this.validateRange(inputNumber);
            return inputNumber;
        });
        this.validateDuplicate();
    }

    static from(input: string) {
        return new GameNumber(input);
    }
    static createRandom() {
        const targetNumberString = generateRandomNumberString(MIN_NUMBER, MAX_NUMBER, NUM_LENGTH);
        return new GameNumber(targetNumberString);
    }

    private validateLength(input: string): void {
        if (input.length !== NUM_LENGTH) {
            throw new Error('숫자 3개를 입력해주세요');
        }
    }

    private validateType(inputNumber: number): void {
        if (isNaN(inputNumber)) {
            throw new Error('숫자를 입력해주세요');
        }
    }

    private validateRange(inputNumber: number): void {
        if (inputNumber < MIN_NUMBER || inputNumber > MAX_NUMBER) {
            throw new Error(`${MIN_NUMBER} ~ ${MAX_NUMBER} 사이의 숫자를 입력해주세요`);
        }
    }

    private validateDuplicate(): void {
        const result = new Set();
        for (let i = 0; i < NUM_LENGTH; i++) {
            result.add(this.numbers[i]);
        }
        if (result.size != this.numbers.length) throw new Error('중복되지 않는 숫자를 입력해주세요');
    }

    getNumbers(): readonly number[] {
        return this.numbers;
    }
}
