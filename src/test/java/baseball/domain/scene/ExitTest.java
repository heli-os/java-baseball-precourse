package baseball.domain.scene;

import baseball.game.BaseBallGameContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ExitTest {

    private final BaseBallGameContext context = new BaseBallGameContext();

    @Test
    void command_수행_시_게임_종료_상태_반환() {
        BaseBallGameScene actual = new Exit().command(context);

        assertThat(actual.getClass()).isEqualTo(Exit.class);
    }

    @Test
    void 플레이_불가_상태() {
        boolean actual = new Exit().playable();

        assertThat(actual).isFalse();
    }
}
