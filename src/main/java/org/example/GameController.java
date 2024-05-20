package org.example;

import org.example.client.GameClient;

public class GameController {

    public static void main(String[] args) {
        GameBox gameBox = new GameBox();
        GameClient gameClient = gameBox.getGameClient();
        gameClient.setUp();
        gameClient.play();
    }

}
