export const CommandType = {
    START_GAME: 1,
    END_GAME: 9,
} as const;

type CommandTypeValues = (typeof CommandType)[keyof typeof CommandType];

export class Command {
    private readonly command: CommandTypeValues;

    constructor(input: string) {
        const inputNumber = parseInt(input);
        this.validateType(inputNumber);
        this.validateCommand(inputNumber);
        this.command = inputNumber as CommandTypeValues;
    }

    validateType(inputNumber: number) {
        if (isNaN(inputNumber)) {
            throw new Error('숫자를 입력해주세요');
        }
    }

    validateCommand(inputNumber: number) {
        if (!(Object.values(CommandType) as number[]).includes(inputNumber)) {
            throw new Error('존재하지 않는 명령어입니다');
        }
    }

    getCommand() {
        return this.command;
    }
}
