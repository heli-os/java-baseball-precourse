package baseball.game;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class CompareResult {

    private final int strike;
    private final int ball;

    protected CompareResult(int strike, int ball) {
        validateGreaterThanOrEqualsZero(strike);
        validateGreaterThanOrEqualsZero(ball);
        this.strike = strike;
        this.ball = ball;
    }

    public static CompareResult strike() {
        return new CompareResult(1, 0);
    }

    public static CompareResult ball() {
        return new CompareResult(0, 1);
    }

    public static CompareResult empty() {
        return new CompareResult(0, 0);
    }

    private void validateGreaterThanOrEqualsZero(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException(String.format("number must be greater than or equals 0. [number=%s]", number));
        }
    }

    public CompareResult add(CompareResult compareResult) {
        return new CompareResult(this.strike + compareResult.strike, this.ball + compareResult.ball);
    }

    @Override
    public String toString() {
        if (this.ball + this.strike == 0) return "낫싱";

        StringBuilder stringBuilder = new StringBuilder();

        if (this.ball > 0) stringBuilder.append(String.format("%s볼 ", this.ball));
        if (this.strike > 0) stringBuilder.append(String.format("%s스트라이크", this.strike));

        return stringBuilder.toString().trim();
    }
}
