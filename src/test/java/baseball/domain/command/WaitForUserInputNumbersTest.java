package baseball.domain.command;

import baseball.game.BaseBallGameContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WaitForUserInputNumbersTest {

    @BeforeEach
    void init() {
        final byte[] buf = String.join("\n", "123").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void command_수행_후_게임_진행_상태로_전환된다() {
        BaseBallGameContext context = new BaseBallGameContext();
        BaseBallGameCommand actual = new WaitForUserInputNumbers().command(context);

        assertThat(actual.getClass()).isEqualTo(Playing.class);
    }

    @Test
    void 플레이_가능_상태() {
        boolean actual = new WaitForUserInputNumbers().playable();

        assertThat(actual).isTrue();
    }
}
