package baseball.domain.result;

import baseball.game.BaseBallNumber;

import java.util.Objects;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class ResultNumber implements BaseBallNumber {

    private final int number;

    public ResultNumber(int number) {
        this.number = number;
    }

    @Override
    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultNumber that = (ResultNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
