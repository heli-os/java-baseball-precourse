package baseball.domain.computer;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComputerTest {

    @Test
    void 컴퓨터의_정답은_1부터_9까지의_숫자로_이루어져있다() {
        Computer actual = new Computer();

        assertThat(actual.resultNumbers().metaData().startInclusive()).isEqualTo(1);
        assertThat(actual.resultNumbers().metaData().endInclusive()).isEqualTo(9);
    }

    @Test
    void 컴퓨터의_정답_길이는_3이다() {
        Computer actual = new Computer();

        assertThat(actual.resultNumbers().metaData().totalSize()).isEqualTo(3);
    }
}
