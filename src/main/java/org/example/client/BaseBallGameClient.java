package org.example.client;

import java.util.List;
import org.example.message.GameMessage;
import org.example.request.ClientRequest;

public class BaseBallGameClient implements GameClient {

    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> randomNumbers;
    private final ClientRequest clientRequest;
    private final BaseBallCounter baseBallCounter = new BaseBallCounter();

    public BaseBallGameClient(
        RandomNumberGenerator randomNumberGenerator,
        ClientRequest clientRequest
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.clientRequest = clientRequest;
    }

    @Override
    public int setup() {
        System.out.println(GameMessage.GAME_START);
        int gameControlNumber = clientRequest.getNumber();
        BaseBallValidator.gameStartEndNumberValidator(gameControlNumber);
        return gameControlNumber;
    }

    @Override
    public void play() {
        getRandomNum();
        playWithNumber();
        System.out.println(GameMessage.GAME_END);
    }

    private void playWithNumber() {
        System.out.println(GameMessage.CHOOSE_NUMBER);
        int clientNumber = clientRequest.getNumber();
        BaseBallValidator.validateClientNumber(clientNumber);
        List<Integer> userInputList = convertingUserNumberToList(clientNumber);
        BallStrikeCount ballStrikeCount = baseBallCounter.checkCount(randomNumbers, userInputList);
        ballStrikeCount.showBallStrikeCount();
        if (ballStrikeCount.strikeCount() != 3) {
            playWithNumber();
        }
    }

    private void getRandomNum() {
        System.out.println(GameMessage.COMPUTER_CHOOSE_NUMBER);
        randomNumbers = randomNumberGenerator.getRandomNumbers();
    }

    private List<Integer> convertingUserNumberToList(int clientNumber) {
        return List.of(
            clientNumber / 100,
            (clientNumber / 10) % 10,
            clientNumber % 10
        );
    }

    @Override
    public void stop() {
        System.out.println(GameMessage.GAME_END);
    }

}
