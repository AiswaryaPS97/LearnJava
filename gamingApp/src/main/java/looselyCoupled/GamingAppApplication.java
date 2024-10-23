package looselyCoupled;



public class GamingAppApplication {
    public static void main(String[] args) {
        GamingConsole game = new MarioGame();
        GameRunners gameRunner = new GameRunners(game);
        gameRunner.run();
    }

}
