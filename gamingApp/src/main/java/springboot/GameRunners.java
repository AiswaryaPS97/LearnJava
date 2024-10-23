package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class GameRunners {
    @Autowired
    private GamingConsole game;

    ArrayList<Integer> a = new ArrayList<Integer>();
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
