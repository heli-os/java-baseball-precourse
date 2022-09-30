package baseball.domain.scene;

import baseball.game.BaseBallGameContext;
import baseball.port.outbound.StandardOutput;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Exit implements BaseBallGameScene {
    @Override
    public BaseBallGameScene next(final BaseBallGameContext context) {
        StandardOutput.println("게임종료");
        return new Exit();
    }

    @Override
    public boolean playable() {
        return false;
    }
}
