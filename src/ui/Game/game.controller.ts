import * as readlinePromises from 'readline/promises';
import { GameNumber } from '../../domain/game-number.model';
import { ResultService } from '../../service/result.service';
import { GamePresenter } from './game.presenter';

export class GameController {
    private static instance: GameController;
    constructor(
        private readonly rl: readlinePromises.Interface,
        private readonly gamePresenter: GamePresenter,
        private readonly resultService: ResultService,
    ) {}

    static getInstance(rl: readlinePromises.Interface, gamePresenter: GamePresenter, resultService: ResultService) {
        if (!GameController.instance) {
            GameController.instance = new GameController(rl, gamePresenter, resultService);
        }
        return GameController.instance;
    }

    async runGame(numLength: number) {
        const targetNumber = GameNumber.createRandom();
        this.gamePresenter.showNumberSet();

        const guessNumber = await this.getGuessNumber();

        let result = await this.resultService.getResult(targetNumber, guessNumber);
        this.gamePresenter.showResult(result);

        while (result.strike !== numLength) {
            const guessNumber = await this.getGuessNumber();

            result = await this.resultService.getResult(targetNumber, guessNumber);
            this.gamePresenter.showResult(result);
        }

        this.gamePresenter.showGameEnd();
    }

    async getGuessNumber(): Promise<GameNumber> {
        const input = await this.getNumbers();
        return GameNumber.from(input);
    }

    async getCommands(): Promise<string> {
        this.gamePresenter.showMenu();
        return await this.rl.question('');
    }

    async getNumbers(): Promise<string> {
        this.gamePresenter.showInputNumber();
        return await this.rl.question('');
    }
}
