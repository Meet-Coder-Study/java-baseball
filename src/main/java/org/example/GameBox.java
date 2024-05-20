package org.example;

import org.example.client.BaseBallGameClient;
import org.example.client.GameClient;
import org.example.client.RandomNumberGenerator;
import org.example.client.RandomNumberGeneratorImpl;
import org.example.request.ClientRequest;
import org.example.request.CommandLineRequest;

public class GameBox {

    private final GameClient gameClient;
    private final RandomNumberGenerator randomNumberGenerator;
    private final ClientRequest clientRequest;

    public GameBox() {
        this.randomNumberGenerator = new RandomNumberGeneratorImpl();
        this.clientRequest = new CommandLineRequest();
        this.gameClient = new BaseBallGameClient(randomNumberGenerator, clientRequest);
    }

    public GameClient getGameClient() {
        return gameClient;
    }

}
