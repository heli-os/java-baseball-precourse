package baseball.domain.command;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public interface BaseBallGameCommand {

    BaseBallGameCommand command(final BaseBallGameContext context);

    boolean playable();
}
