package looselyCoupled;

public class GameRunners {

    private  GamingConsole game;
    public GameRunners(GamingConsole game) {
        this.game = game;
    }

    public  void run() {
        game.down();
        game.up();
        game.left();
        game.right();
    }
}
