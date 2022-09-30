package baseball.game;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class BaseBallGame {

    private final BaseBallGameContext baseBallGameContext = new BaseBallGameContext();

    public void start() {
        while (baseBallGameContext.playable()) {
            baseBallGameContext.play();
        }
    }
}
