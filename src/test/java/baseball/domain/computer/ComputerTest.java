package baseball.domain.computer;

import baseball.domain.number.BaseBallNumber;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComputerTest {

    @RepeatedTest(10)
    void 컴퓨터의_정답은_1부터_9까지의_숫자로_이루어져있다() {
        ValueRange valueRange = ValueRange.of(1, 9);
        Computer computer = new Computer();

        List<BaseBallNumber> actual = computer.resultNumbers().numbers();

        actual.forEach(resultNumber ->
                assertThat(valueRange.isValidValue(resultNumber.value())).isTrue()
        );
    }

    @Test
    void 컴퓨터의_정답_길이는_3이다() {
        Computer computer = new Computer();

        ArrayList<BaseBallNumber> actual = Lists.newArrayList(computer.resultNumbers().numbers());

        assertThat(actual).hasSize(3);
    }
}
