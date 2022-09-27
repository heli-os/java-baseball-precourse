package baseball.domain;

import baseball.domain.result.ResultNumbers;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultNumbersTest {

    @Test
    void 크기_3인_정답_숫자를_생성할_수_있다() {
        ResultNumbers actual = new ResultNumbers(3, 1, 9);

        assertThat(actual.metaData().totalSize()).isEqualTo(3);
    }

    @Test
    void 정답_숫자_생성_시_메타데이터가_정상적으로_세팅된다() {
        ResultNumbers actual = new ResultNumbers(3, 1, 9);

        assertThat(actual.metaData().totalSize()).isEqualTo(3);
        assertThat(actual.metaData().startInclusive()).isEqualTo(1);
        assertThat(actual.metaData().endInclusive()).isEqualTo(9);
    }

    @Test
    void 숫자_범위의_시작은_범위의_끝_보다_작아야_한다() {
        assertThatThrownBy(() -> new ResultNumbers(3, 9999, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("startInclusive cannot be greater than endInclusive.");
    }

    @Test
    void 전체_크기는_숫자_범위보다_작아야_한다() {
        assertThatThrownBy(() -> new ResultNumbers(100, 1, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("totalSize cannot be greater than rangeSize(endInclusive - startInclusive + 1)");
    }
}
