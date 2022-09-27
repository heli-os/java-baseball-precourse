package baseball.domain.command;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class WaitForUserInputNumbers implements BaseBallGameCommand {
    @Override
    public BaseBallGameCommand command(final BaseBallGameContext context) {
        context.userInput();
        return new Playing();
    }

    @Override
    public boolean playable() {
        return true;
    }
}
