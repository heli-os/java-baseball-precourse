package baseball.domain.player;

import baseball.domain.input.InputNumbers;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Player {

    private final InputNumbers inputNumbers;

    public Player(final String input) {
        this.inputNumbers = new InputNumbers(input);
    }

    public InputNumbers inputNumbers() {
        return inputNumbers;
    }
}
