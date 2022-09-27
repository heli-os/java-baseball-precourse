package baseball.domain.input;

import baseball.domain.number.BaseBallNumber;

import java.util.Objects;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class StringAsPositiveInteger implements BaseBallNumber {

    private final int value;

    public StringAsPositiveInteger(String input) {
        int number = Integer.parseInt(input);
        validatePositive(number);
        this.value = number;
    }

    @Override
    public int value() {
        return value;
    }

    private void validatePositive(final int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(String.format("number must be greater than 0. [number=%s]", number));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBallNumber)) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return value() == that.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(value());
    }

    @Override
    public String toString() {
        return String.valueOf(value());
    }
}
