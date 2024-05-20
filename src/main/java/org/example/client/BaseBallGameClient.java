package org.example.client;

import java.util.List;
import org.example.request.ClientRequest;

public class BaseBallGameClient implements GameClient {

    private final RandomNumberGenerator randomNumberGenerator;
    private List<Integer> randomNumbers;
    private final ClientRequest clientRequest;

    public BaseBallGameClient(
        RandomNumberGenerator randomNumberGenerator,
        ClientRequest clientRequest
    ) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.clientRequest = clientRequest;
    }

    @Override
    public void setUp() {
        randomNumbers = randomNumberGenerator.getRandomNumbers();
    }

    @Override
    public void play() {

    }

    @Override
    public void stop() {

    }

}
