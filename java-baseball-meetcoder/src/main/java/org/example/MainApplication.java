package org.example;

import org.example.adapter.controller.BaseballGame;
import org.example.common.config.DiContainter;

public class MainApplication {
    public static void main(String[] args) {
        BaseballGame baseballGame = DiContainter.loadGame();
        baseballGame.start();
    }
}