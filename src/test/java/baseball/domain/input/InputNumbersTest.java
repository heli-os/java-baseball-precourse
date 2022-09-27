package baseball.domain.input;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 입력은_1부터_9까지의_숫자로_이루어져있다(String input) {
        InputNumbers inputNumbers = new InputNumbers(input);

        Iterator<StringAsPositiveInteger> actual = inputNumbers.numbers();

        actual.forEachRemaining((number) -> {
            assertThat(number.value())
                    .isGreaterThanOrEqualTo(1)
                    .isLessThanOrEqualTo(9);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 입력_길이는_3이다(String input) {
        InputNumbers inputNumbers = new InputNumbers(input);

        ArrayList<StringAsPositiveInteger> actual = Lists.newArrayList(inputNumbers.numbers());

        assertThat(actual).hasSize(3);
    }
}
