package baseball.domain.input;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StringAsPositiveIntegerTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 정수_형태의_String_타입_인풋으로_인스턴스를_만들_수_있다(String input) {
        StringAsPositiveInteger actual = new StringAsPositiveInteger(input);

        assertThat(actual.value()).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c"})
    void 문자_형태의_String_타입_인풋으로_인스턴스를_만들_수_없다(String input) {
        assertThatThrownBy(() -> new StringAsPositiveInteger(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"-2", "-1", "0"})
    void 양의_정수_만_받을_수_있다(String input) {
        assertThatThrownBy(() -> new StringAsPositiveInteger(input));
    }
}
