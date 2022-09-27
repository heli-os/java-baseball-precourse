package baseball.domain.computer;

import baseball.domain.result.ResultNumbers;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class Computer {

    private static final int TOTAL_SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private final ResultNumbers resultNumbers;

    public Computer() {
        this.resultNumbers = new ResultNumbers(TOTAL_SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    public ResultNumbers resultNumbers() {
        return resultNumbers;
    }
}
