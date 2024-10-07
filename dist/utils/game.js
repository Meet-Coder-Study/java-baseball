import { compareNumbers } from './compareNumbers';
import { formatDate } from './formatDate';
import { generateRandomNum } from './randomNumber';
export const createGame = () => {
    // 게임 상태
    let randomNumber = [];
    let chances = 3;
    let isGameStarted = false;
    let gameRecord = [];
    //  게임 시작
    const startGame = () => {
        randomNumber = generateRandomNum();
        chances = 3;
        isGameStarted = true;
        const game = {
            id: gameRecord.length + 1,
            start: formatDate(new Date()),
            end: undefined,
            attempt: 0,
            detailResult: {
                inputData: [],
                resultList: [],
            },
            isSuccess: false,
            message: '',
        };
        gameRecord.push(game);
    };
    //  게임 리셋
    const resetGame = () => {
        const currentGame = gameRecord[Math.max(0, gameRecord.length - 1)];
        currentGame.end = formatDate(new Date());
        isGameStarted = false;
    };
    // 게임이 시작됐는지 여부
    const getIsGameStarted = () => isGameStarted;
    //  입력 값 검사
    const checkNum = (input) => {
        const currentGame = gameRecord[Math.max(0, gameRecord.length - 1)];
        if (!/^\d{3}$/.test(input.trim())) {
            return '3자리 숫자를 입력하세요';
        }
        const gameResult = compareNumbers(randomNumber, input);
        chances--;
        currentGame.attempt++;
        currentGame.detailResult.inputData.push(input);
        currentGame.detailResult.resultList.push(`strike: ${gameResult.strike}, ball: ${gameResult.ball}`);
        if (gameResult.strike === 3) {
            isGameStarted = false;
            currentGame.isSuccess = true;
            currentGame.end = formatDate(new Date());
            currentGame.message = '3개의 숫자를 모두 맞히셨습니다.';
            return `3개의 숫자를 모두 맞히셨습니다.\n-------게임 종료-------`;
        }
        if (chances === 0) {
            isGameStarted = false;
            currentGame.isSuccess = false;
            currentGame.end = formatDate(new Date());
            currentGame.message = '3개의 숫자를 모두 맞히지 못하셨습니다.';
            return `3개의 숫자를 모두 맞히지 못하셨습니다.\n-------게임 종료-------`;
        }
        return gameResult.ball === 0 ? '낫싱' : `strike: ${gameResult.strike}, ball: ${gameResult.ball}`;
    };
    const getGameRecords = () => {
        return gameRecord.map((record) => ({
            id: record.id,
            start: record.start,
            end: record.end,
            attempt: record.attempt,
        }));
    };
    const getDetailGameRecords = (id) => {
        const record = gameRecord.find((record) => record.id === id);
        if (!record) {
            return '기록이 없습니다.';
        }
        let detail = `${record.id}번 게임 결과 \n `;
        record.detailResult.inputData.forEach((input, index) => {
            const result = record.detailResult.resultList[index];
            detail += `숫자를 입력해주세요: ${input}\n${result}\n`;
        });
        if (record.message) {
            detail += `\n${record.message}\n-------기록 종료-------`;
        }
        return detail;
    };
    const getTotalRecords = () => {
        return gameRecord.map((record) => ({
            id: record.id,
            attempt: record.attempt,
        }));
    };
    return {
        startGame,
        resetGame,
        checkNum,
        getIsGameStarted,
        getGameRecords,
        getDetailGameRecords,
        getTotalRecords,
    };
};
