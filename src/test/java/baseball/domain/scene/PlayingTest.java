package baseball.domain.scene;

import baseball.game.BaseBallGameContext;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayingTest {

    private final BaseBallGameContext context = new BaseBallGameContext();
    private BaseBallGameScene scene = new ReadyToStart();

    @BeforeEach
    void init() {
        final byte[] buf = String.join("\n", "123").getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Test
    void 숫자를_모두_맞히지_못하였다면_게임_플레이어_입력_상태로_전환된다() {
        scene = scene.next(context); // ReadyToStart -> WaitForUserInputNumbers
        scene = scene.next(context); // WaitForUserInputNumbers -> Playing
        BaseBallGameScene actual = scene.next(context);

        assertThat(actual.getClass()).isEqualTo(WaitForUserInputNumbers.class);
    }

    @Test
    void 숫자를_모두_맞혔다면_게임_완료_상태로_전환된다() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(
                    () -> Randoms.pickNumberInRange(anyInt(), anyInt())
            ).thenReturn(1, 1, 2, 3);
            scene = scene.next(context); // ReadyToStart -> WaitForUserInputNumbers
            scene = scene.next(context); // WaitForUserInputNumbers -> Playing
            BaseBallGameScene actual = scene.next(context);
            assertThat(actual.getClass()).isEqualTo(Finish.class);
        }
    }

    @Test
    void 플레이_가능_상태() {
        boolean actual = new ReadyToStart().playable();

        assertThat(actual).isTrue();
    }
}
