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
class ReadyToStartTest {

    @Test
    void command_수행_후_게임_플레이어_입력_상태로_전환된다() {
        BaseBallGameContext context = new BaseBallGameContext();
        BaseBallGameScene actual = new ReadyToStart().command(context);

        assertThat(actual.getClass()).isEqualTo(WaitForUserInputNumbers.class);
    }

    @Test
    void 플레이_가능_상태() {
        boolean actual = new ReadyToStart().playable();

        assertThat(actual).isTrue();
    }
}
