package com.game.gamingApp.game;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is tightly coupled code
 * If we need to run another game than mario , need code change everytime
 * GameRunner cls is tightly couples to MarioGame
 */
@SpringBootApplication
public class GamingAppApplication {

	public static void main(String[] args) {

		//SpringApplication.run(GamingAppApplication.class, args);
		MarioGame marioGame = new MarioGame();
		GameRunner gameRunner = new GameRunner(marioGame);
		gameRunner.run();
	}

}
