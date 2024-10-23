package springboot;


import com.game.gamingApp.game.GameRunner;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class GamingAppApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(GamingAppApplication.class, args);
        GameRunners gameRunner = context.getBean(GameRunners.class);
        gameRunner.run();
    }

}
