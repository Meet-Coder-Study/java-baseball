import { Readable, ReadableOptions } from 'node:stream';

class TestStream extends Readable {
    private chunk: string;
    private pushed: boolean;
    constructor(chunk: string, options?: ReadableOptions) {
        super(options);
        this.chunk = chunk;
        this.pushed = false;
    }

    _read(): void {
        if (!this.pushed) {
            this.push(this.chunk, 'utf8');
            this.pushed = true;
        } else {
            this.push(null);
        }
    }
}

// describe('입/출력 테스트', () => {
//     it('사용자가 숫자가 아닌 값을 입력하면', () => {
//         const numberStream = new TestStream('a');
//         const rl = readlinePromises.createInterface({ input: numberStream, output: stdout });
//     });
// });
