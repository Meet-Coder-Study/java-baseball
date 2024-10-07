import { start } from 'repl';
import { compareNumbers } from './compareNumbers';
import { formatDate } from './formatDate';
import { generateRandomNum } from './randomNumber';

type GameResult = {
  inputData: string[];
  resultList: string[];
};

export interface GameRecord {
  id: number;
  start: string;
  end?: string;
  attempt: number;
  detailResult: GameResult;
  isSuccess: boolean;
  message: string;
}

export const createGame = () => {
  // 게임 상태
  let randomNumber: string[] = [];
  let chances: number = 3;
  let isGameStarted: boolean = false;
  let gameRecord: GameRecord[] = [];

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
  const checkNum = (input: string) => {
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

  const getDetailGameRecords = (id: number) => {
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

  const getTotalListRecords = () => {
    const successfulGames = gameRecord.filter((record) => record.isSuccess);

    if (successfulGames.length === 0) {
      return '성공한 기록이 없습니다.';
    }

    const totalListRecords = successfulGames
      .map((record) => ({
        id: record.id,
        attempt: record.attempt,
      }))
      .sort((a, b) => a.attempt - b.attempt);

    const totalAllRecords = totalListRecords.reduce((acc, cur) => {
      return acc + cur.attempt;
    }, 0);

    const averageAttempt = totalAllRecords / totalListRecords.length;
    const first = totalListRecords[0];
    const last = totalListRecords[totalListRecords.length - 1];
    return `
    가장 적은 횟수: ${first.attempt}회 - [${first.id}]
    가장 많은 횟수: ${last.attempt}회 - [${last.id}]
    평균횟수: ${averageAttempt.toFixed(2)}회
    
    -------통계 종료-------
        `;
  };

  return {
    startGame,
    resetGame,
    checkNum,
    getIsGameStarted,
    getGameRecords,
    getDetailGameRecords,
    getTotalListRecords,
  };
};
