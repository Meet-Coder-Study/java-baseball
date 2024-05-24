package org.example;

import org.example.controller.BaseBallGameController;
import org.example.controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new BaseBallGameController(new BaseBallGameBox());
        gameController.run();
    }

}
