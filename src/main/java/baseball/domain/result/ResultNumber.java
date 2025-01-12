package baseball.domain.result;

import baseball.domain.number.BaseBallNumber;

import java.util.Objects;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class ResultNumber implements BaseBallNumber {

    private final int number;

    public ResultNumber(final int number) {
        this.number = number;
    }

    @Override
    public int value() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseBallNumber)) return false;
        BaseBallNumber that = (BaseBallNumber) o;
        return value() == that.value();
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(value());
    }
}
