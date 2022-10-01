package baseball.domain.scene;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class ReadyToStart implements BaseBallGameScene {
    @Override
    public BaseBallGameScene play(final BaseBallGameContext context) {
        context.init();
        return new WaitForUserInputNumbers();
    }

    @Override
    public boolean playable() {
        return true;
    }
}
