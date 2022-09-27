package baseball.game;

import java.util.List;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class Compare {

    public CompareResult compare(final List<BaseBallNumber> inputNumbers, final List<BaseBallNumber> resultNumbers) {
        validateSameSize(inputNumbers, resultNumbers);

        CompareResult compareResult = CompareResult.empty();
        for (int i = 0; i < inputNumbers.size(); i++) {
            compareResult = compareResult.add(compare(i, inputNumbers, resultNumbers));
        }

        return compareResult;
    }

    private void validateSameSize(final List<BaseBallNumber> inputNumbers, final List<BaseBallNumber> resultNumbers) {
        if (inputNumbers.size() != resultNumbers.size()) {
            throw new IllegalArgumentException("comparison lists must be have same size.");
        }
    }

    private CompareResult compare(final int position, final List<BaseBallNumber> inputNumbers, final List<BaseBallNumber> resultNumbers) {
        BaseBallNumber inputNumber = inputNumbers.get(position);
        BaseBallNumber resultNumber = resultNumbers.get(position);

        if (isStrike(inputNumber, resultNumber)) {
            return CompareResult.strike();
        }
        if (hasBall(inputNumber, resultNumbers)) {
            return CompareResult.ball();
        }
        return CompareResult.empty();
    }

    private boolean isStrike(final BaseBallNumber inputNumber, final BaseBallNumber resultNumber) {
        return inputNumber.equals(resultNumber);
    }

    private boolean hasBall(final BaseBallNumber inputNumber, final List<BaseBallNumber> resultNumbers) {
        return resultNumbers.contains(inputNumber);
    }
}
