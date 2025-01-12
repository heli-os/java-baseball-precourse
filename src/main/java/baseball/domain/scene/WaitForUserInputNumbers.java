package baseball.domain.scene;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class WaitForUserInputNumbers implements BaseBallGameScene {
    @Override
    public BaseBallGameScene next(final BaseBallGameContext context) {
        context.userInput();
        return new Playing();
    }

    @Override
    public boolean playable() {
        return true;
    }
}
