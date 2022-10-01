package baseball.domain.scene;

import baseball.game.BaseBallGameContext;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public interface BaseBallGameScene {

    BaseBallGameScene play(final BaseBallGameContext context);

    boolean playable();
}
