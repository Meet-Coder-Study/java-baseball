import { stdin, stdout } from 'node:process';
import * as readlinePromises from 'node:readline/promises';
import { NUM_LENGTH } from './const/num-range';
import { Command, CommandType } from './domain/command.model';
import { ResultService } from './service/result.service';
import { GameController } from './ui/Game/game.controller';
import { GamePresenter } from './ui/Game/game.presenter';

async function createReadline(input: NodeJS.ReadableStream, output: NodeJS.WritableStream) {
    return readlinePromises.createInterface({ input, output });
}

async function main() {
    const rl = await createReadline(stdin, stdout);
    const resultService = new ResultService();
    const gamePresenter = new GamePresenter();
    const gameController = GameController.getInstance(rl, gamePresenter, resultService);

    const input = await gameController.getCommands();
    let command = new Command(input);
    while (command.getCommand() != CommandType.END_GAME) {
        switch (command.getCommand()) {
            case CommandType.START_GAME:
                await gameController.runGame(NUM_LENGTH);
                break;
        }
        const input = await gameController.getCommands();
        command = new Command(input);
    }
    rl.close();
}

main().catch(console.error);
