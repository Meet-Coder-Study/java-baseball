package org.example;

import org.example.client.BaseBallGameClient;
import org.example.client.GameClient;

public class GameController {

    public static void main(String[] args) {
        GameClient gameClient = new BaseBallGameClient();
        gameClient.setUp();
        gameClient.play();
    }

}
