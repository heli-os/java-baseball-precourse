package baseball.domain.scene;

import baseball.game.BaseBallGameContext;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class FinishTest {

    private final BaseBallGameContext context = new BaseBallGameContext();

    @Test
    void press_1_continue() {
        final byte[] buf = String.join("\n", "1").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BaseBallGameScene actual = new Finish().command(context);

        assertThat(actual.getClass()).isEqualTo(ReadyToStart.class);
    }

    @Test
    void press_2_exit() {
        final byte[] buf = String.join("\n", "2").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        BaseBallGameScene actual = new Finish().command(context);

        assertThat(actual.getClass()).isEqualTo(Exit.class);
    }

    @Test
    void press_others_exception() {
        final byte[] buf = String.join("\n", "q").getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThatThrownBy(() -> new Finish().command(context))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임종료");
    }

    @Test
    void 플레이_가능_상태() {
        boolean actual = new Finish().playable();

        assertThat(actual).isTrue();
    }
}
