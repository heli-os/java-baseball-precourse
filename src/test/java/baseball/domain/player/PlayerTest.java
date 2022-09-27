package baseball.domain.player;

import baseball.domain.input.InputNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void 플레이어는_입력_받은_값_으로_InputNumbers_를_생성한다(String input) {
        Player player = new Player(input);

        InputNumbers inputNumbers = player.inputNumbers();
        Assertions.assertNotNull(inputNumbers);
    }
}
