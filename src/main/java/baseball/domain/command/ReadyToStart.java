package baseball.domain.command;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class ReadyToStart implements BaseBallGameCommand {
    @Override
    public BaseBallGameCommand command(BaseBallGameContext context) {
        context.init();
        return new WaitForUserInputNumbers();
    }

    @Override
    public boolean playable() {
        return true;
    }
}
