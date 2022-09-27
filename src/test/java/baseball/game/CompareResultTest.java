package baseball.game;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompareResultTest {

    @Test
    void one_strike() {
        CompareResult actual = CompareResult.strike();

        assertThat(actual.toString()).isEqualTo("1스트라이크");
    }

    @Test
    void one_ball() {
        CompareResult actual = CompareResult.ball();

        assertThat(actual.toString()).isEqualTo("1볼");
    }

    @Test
    void nothing() {
        CompareResult actual = CompareResult.empty();

        assertThat(actual.toString()).isEqualTo("낫싱");
    }

    @Test
    void three_strike() {
        CompareResult actual = CompareResult.empty()
                .add(CompareResult.strike())
                .add(CompareResult.strike())
                .add(CompareResult.strike());

        assertThat(actual.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void three_ball() {
        CompareResult actual = CompareResult.empty()
                .add(CompareResult.ball())
                .add(CompareResult.ball())
                .add(CompareResult.ball());

        assertThat(actual.toString()).isEqualTo("3볼");
    }

    @Test
    void one_ball_two_strike() {
        CompareResult actual = CompareResult.empty()
                .add(CompareResult.ball())
                .add(CompareResult.strike())
                .add(CompareResult.strike());

        assertThat(actual.toString()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void 스트라이크는_음수_일_수_없다() {
        assertThatThrownBy(() -> new CompareResult(-1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("number must be greater than or equals 0. [number=");
    }

    @Test
    void 볼은_음수_일_수_없다() {
        assertThatThrownBy(() -> new CompareResult(0, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("number must be greater than or equals 0. [number=");
    }
}
