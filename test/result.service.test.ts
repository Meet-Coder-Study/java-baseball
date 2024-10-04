import { GameNumber } from '../src/domain/game-number.model';
import { ResultService } from '../src/service/result.service';

describe('ResultService 클래스', () => {
    const resultService = new ResultService();
    describe('CompareNumbers 테스트', () => {
        test.each([
            ['123', '145', { strike: 1, ball: 0 }],
            ['123', '425', { strike: 1, ball: 0 }],
            ['123', '453', { strike: 1, ball: 0 }],
        ])('숫자 하나만 위치까지 같을 때 strike 1 ball 0이다 (정답: %s, 입력: %s)', (target, guess, expected) => {
            const targetNumber = GameNumber.from(target);
            const guessNumber = GameNumber.from(guess);
            const resultService = new ResultService();
            expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
        });

        test.each([
            ['123', '125', { strike: 2, ball: 0 }],
            ['123', '423', { strike: 2, ball: 0 }],
            ['123', '153', { strike: 2, ball: 0 }],
        ])('숫자 두개가 위치까지 같을 때 strike 2 ball 0이다 (정답: %s, 입력: %s)', (target, guess, expected) => {
            const targetNumber = GameNumber.from(target);
            const guessNumber = GameNumber.from(guess);
            expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
        });

        test.each([['123', '123', { strike: 3, ball: 0 }]])(
            '숫자 세개가 위치까지 같을 때 strike 3 ball 0이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );

        test.each([
            ['123', '915', { strike: 0, ball: 1 }],
            ['123', '249', { strike: 0, ball: 1 }],
            ['123', '837', { strike: 0, ball: 1 }],
        ])(
            '정답에 포함되지만 위치가 다른 숫자가 1개 있을 때 strike 0 ball 1이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );

        test.each([
            ['123', '315', { strike: 0, ball: 2 }],
            ['123', '241', { strike: 0, ball: 2 }],
            ['123', '831', { strike: 0, ball: 2 }],
        ])(
            '정답에 포함되지만 위치가 다른 숫자가 2개 있을 때 strike 0 ball 2이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );

        test.each([
            ['123', '312', { strike: 0, ball: 3 }],
            ['123', '231', { strike: 0, ball: 3 }],
            ['123', '231', { strike: 0, ball: 3 }],
        ])(
            '정답에 포함되지만 위치가 다른 숫자가 3개 있을 때 strike 0 ball 3이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );

        test.each([['123', '132', { strike: 1, ball: 2 }]])(
            '위치까지 맞는 숫자 1개, 위치가 맞지 않는 숫자 2개가 있을 때 strike 1 ball 2이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );

        test.each([['123', '987', { strike: 0, ball: 0 }]])(
            '포함되는 숫자가 없을 때 strike 0 ball 0이다 (정답: %s, 입력: %s)',
            (target, guess, expected) => {
                const targetNumber = GameNumber.from(target);
                const guessNumber = GameNumber.from(guess);
                expect(resultService.getResult(targetNumber, guessNumber)).toEqual(expected);
            },
        );
    });
});
