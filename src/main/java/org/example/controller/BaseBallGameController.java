package org.example.controller;

import org.example.BaseBallGameBox;
import org.example.client.GameClient;
import org.example.exception.BaseBallException;

public class BaseBallGameController implements GameController {

    private final BaseBallGameBox gameBox;

    public BaseBallGameController(BaseBallGameBox gameBox) {
        this.gameBox = gameBox;
    }

    @Override
    public void run() {
        GameClient gameClient = gameBox.getGameClient();
        int setupNumber;
        try {
            setupNumber = gameClient.setup();
        } catch (BaseBallException e) {
            System.out.println(e.getMessage());
            run();
            return;
        }
        if(setupNumber == 1) {
            gameClient.play();
            run();
            return;
        }
        gameClient.stop();
    }

}
