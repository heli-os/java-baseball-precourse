package baseball.domain.result;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class ResultNumber {

    private final long number;

    public ResultNumber(long number) {
        this.number = number;
    }

    public long value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultNumber that = (ResultNumber) o;
        return value() == that.value();
    }
}
