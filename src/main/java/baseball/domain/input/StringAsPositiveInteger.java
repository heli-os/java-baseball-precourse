package baseball.domain.input;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class StringAsPositiveInteger {

    private final int value;

    public StringAsPositiveInteger(String input) {
        int number = Integer.parseInt(input);
        validatePositive(number);
        this.value = number;
    }

    public int value() {
        return value;
    }

    private void validatePositive(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format("number must be greater than 0. [number=%s]", number));
        }
    }
}
