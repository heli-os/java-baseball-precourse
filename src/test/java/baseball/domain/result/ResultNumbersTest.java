package baseball.domain.result;

import baseball.domain.number.BaseBallNumber;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;

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
        ResultNumbers resultNumbers = new ResultNumbers(3, 1, 9);

        ArrayList<BaseBallNumber> actual = Lists.newArrayList(resultNumbers.numbers());

        assertThat(actual.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "2:1:2", "3:1:3"}, delimiter = ':')
    void 정답_숫자_생성_시_중복은_없다(final int totalSize, final int startInclusive, final int endInclusive) {
        ResultNumbers resultNumbers = new ResultNumbers(totalSize, startInclusive, endInclusive);

        ArrayList<BaseBallNumber> actual = Lists.newArrayList(resultNumbers.numbers());
        HashSet<BaseBallNumber> setValues = Sets.newHashSet(actual);

        assertThat(actual).hasSameSizeAs(setValues);
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
