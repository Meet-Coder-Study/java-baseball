import { createGame } from './utils/game';
import { updateGameMessage } from './utils/updateGameMessage';

// Dom과 연결
const form = document.querySelector('form') as HTMLFormElement;
const userInput = document.getElementById('userInput') as HTMLInputElement;
const result = document.getElementById('result') as HTMLElement;

const game = createGame();
let isViewingRecords = false;

form.addEventListener('submit', (e) => {
  e.preventDefault();
  handleUserInput(userInput.value.trim());
});

const handleUserInput = (input: string) => {
  if (isViewingRecords) {
    const detail = game.getDetailGameRecords(Number(input));
    updateGameMessage(result, detail);
    userInput.value = '';
    isViewingRecords = false;
    return;
  }

  switch (input) {
    case '1':
      startGame();
      break;
    case '2':
      showGameRecords();
      break;
    case '3':
      showTotalGameRecords();
      break;
    case '9':
      endGame();
      break;
    default:
      if (game.getIsGameStarted()) {
        updateGameMessage(result, game.checkNum(input));
        return (userInput.value = '');
      }
      updateGameMessage(result, '게임을 시작하려면 먼저 1을 입력해주세요.');
  }
};

const startGame = () => {
  game.startGame();
  updateGameMessage(result, '컴퓨터가 숫자를 뽑았습니다');
  userInput.value = '';
};

const endGame = () => {
  game.resetGame();
  updateGameMessage(result, '애플리케이션이 종료되었습니다.');
  userInput.value = '';
};

const showGameRecords = () => {
  const records = game.getGameRecords();
  let message = '게임 기록:\n';
  records.forEach((record) => {
    message += `[${record.id}] / 시작시간: ${record.start} / 종료시간: ${record.end} / 횟수: ${record.attempt}\n`;
  });
  updateGameMessage(result, message);
  isViewingRecords = true;
  userInput.value = '';
};

const showTotalGameRecords = () => {
  updateGameMessage(result, game.getTotalListRecords());
};
