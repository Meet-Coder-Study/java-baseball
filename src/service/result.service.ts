import { GameNumber } from '../domain/game-number.model';
import { ResultResponse } from '../dto/result-response.dto';

export class ResultService {
    constructor() {}

    private compareNumbers(targetNumber: GameNumber, guessNumber: GameNumber): ResultResponse {
        const target = targetNumber.getNumbers();
        const guess = guessNumber.getNumbers();

        const strike = this.calculateStrike(target, guess);
        const ball = this.calculateBall(target, guess);

        return { strike, ball };
    }

    private calculateStrike(target: readonly number[], guess: readonly number[]): number {
        return target.reduce((count, digit, index) => (digit === guess[index] ? count + 1 : count), 0);
    }

    private calculateBall(target: readonly number[], guess: readonly number[]): number {
        return guess.reduce(
            (count, digit, index) => (target.includes(digit) && target[index] !== digit ? count + 1 : count),
            0,
        );
    }

    getResult(targetNumber: GameNumber, guessNumber: GameNumber) {
        return this.compareNumbers(targetNumber, guessNumber);
    }
}
