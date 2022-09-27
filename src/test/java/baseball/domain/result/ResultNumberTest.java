package baseball.domain.result;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ResultNumberTest {

    @Test
    void ResultNumber_는_하나의_long_타입_필드를_가진다() {
        ResultNumber resultNumber = new ResultNumber(5);

        assertThat(resultNumber.value()).isEqualTo(5);
    }

    @Test
    void 서로_다른_ResultNumber_인스턴스라도_값이_같다면_equals_메소드_비교시_true_를_반환한다() {
        ResultNumber firstStub = new ResultNumber(5);
        ResultNumber secondStub = new ResultNumber(5);

        assertEquals(firstStub, secondStub);
    }

    @Test
    void 서로_다른_값을_가졌다면_equals_메소드_비교시_false_를_반환한다() {
        ResultNumber firstStub = new ResultNumber(-1);
        ResultNumber secondStub = new ResultNumber(1);

        assertNotEquals(firstStub, secondStub);
    }
}
