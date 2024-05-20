package org.example;

import org.example.client.BaseBallGameClient;
import org.example.client.GameClient;
import org.example.client.RandomNumberGeneratorImpl;
import org.example.request.CommandLineRequest;

public class GameController {

    public static void main(String[] args) {
        GameClient gameClient = new BaseBallGameClient(new RandomNumberGeneratorImpl(), new CommandLineRequest());
        gameClient.setUp();
        gameClient.play();
    }

}
