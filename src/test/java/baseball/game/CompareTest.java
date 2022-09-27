package baseball.game;

import baseball.domain.number.BaseBallNumber;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CompareTest {

    @Test
    void 두_리스트의_값이_같으면_3_스트라이크() {
        List<BaseBallNumber> inputNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));
        List<BaseBallNumber> resulNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));

        CompareResult actual = new Compare().compare(inputNumbers, resulNumbers);

        assertThat(actual.toString()).isEqualTo("3스트라이크");
    }

    @Test
    void 두_리스트의_크기가_다르면_오류_발생() {
        List<BaseBallNumber> inputNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));
        List<BaseBallNumber> resulNumbers = Lists.list(new FakeNumber(1));

        assertThatThrownBy(() -> new Compare().compare(inputNumbers, resulNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("comparison lists must be have same size.");
    }

    @Test
    void 다른_위치_같은_숫자가_1개_있는_경우_1볼() {
        List<BaseBallNumber> inputNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));
        List<BaseBallNumber> resulNumbers = Lists.list(new FakeNumber(4), new FakeNumber(5), new FakeNumber(1));

        CompareResult actual = new Compare().compare(inputNumbers, resulNumbers);

        assertThat(actual.toString()).isEqualTo("1볼");
    }


    @Test
    void 다른_위치_같은_숫자가_2개_있는_경우_2볼() {
        List<BaseBallNumber> inputNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));
        List<BaseBallNumber> resulNumbers = Lists.list(new FakeNumber(4), new FakeNumber(3), new FakeNumber(1));

        CompareResult actual = new Compare().compare(inputNumbers, resulNumbers);

        assertThat(actual.toString()).isEqualTo("2볼");
    }

    @Test
    void 같은_위치_같은_숫자가_1개_있고_다른_위치_같은_숫자가_2개_있는_경우_2볼_1스트라이크() {
        List<BaseBallNumber> inputNumbers = Lists.list(new FakeNumber(1), new FakeNumber(2), new FakeNumber(3));
        List<BaseBallNumber> resulNumbers = Lists.list(new FakeNumber(1), new FakeNumber(3), new FakeNumber(2));

        CompareResult actual = new Compare().compare(inputNumbers, resulNumbers);

        assertThat(actual.toString()).isEqualTo("2볼 1스트라이크");
    }

    private static class FakeNumber implements BaseBallNumber {

        private final int number;

        public FakeNumber(int number) {
            this.number = number;
        }

        @Override
        public int value() {
            return number;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            FakeNumber that = (FakeNumber) o;
            return number == that.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}
