package baseball.domain.command;

import baseball.game.BaseBallGameContext;
import baseball.port.outbound.StandardOutput;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Exit implements BaseBallGameCommand {
    @Override
    public BaseBallGameCommand command(final BaseBallGameContext context) {
        StandardOutput.println("게임종료");
        return new Exit();
    }

    @Override
    public boolean playable() {
        return false;
    }
}
