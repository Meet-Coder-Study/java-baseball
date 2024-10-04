import { NUM_LENGTH } from '../../const/num-range';
import { ResultResponse } from '../../dto/result-response.dto';

export class GamePresenter {
    showMenu() {
        console.log('1: 새 게임 시작');
        console.log('9: 게임 종료');
    }

    showNumberSet() {
        console.log('컴퓨터가 숫자를 뽑았습니다');
    }

    showInputNumber() {
        console.log('숫자를 입력해주세요');
    }

    showResult(result: ResultResponse) {
        let resultString = '';
        result.strike ? (resultString += `스트라이크 : ${result.strike}`) : resultString;
        result.ball ? (resultString += ` 볼 : ${result.ball}`) : resultString;
        resultString === '' ? (resultString += '낫싱') : resultString;

        console.log(resultString);
    }

    showGameEnd() {
        console.log(`${NUM_LENGTH}개의 숫자를 모두 맞히셨습니다.`);
        console.log('----------- 게임 종료 -----------');
    }
}
