package baseball.domain.computer;

import baseball.domain.result.ResultNumbers;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class Computer {

    private final ResultNumbers resultNumbers;

    public Computer() {
        this.resultNumbers = new ResultNumbers(3, 1, 9);
    }

    public ResultNumbers resultNumbers() {
        return resultNumbers;
    }
}
