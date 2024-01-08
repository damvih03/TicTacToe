package com.damvih;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(Settings.CLASSIC);
        game.gameLoop();
        System.out.println(game.getGameState().toString());
    }
}
