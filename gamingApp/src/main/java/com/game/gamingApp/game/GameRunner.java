package com.game.gamingApp.game;


public class GameRunner {

    private MarioGame marioGame;
    public GameRunner(MarioGame marioGame) {
        this.marioGame = marioGame;
    }

    public void run() {
        marioGame.down();
        marioGame.up();
        marioGame.left();
        marioGame.right();
    }
}
