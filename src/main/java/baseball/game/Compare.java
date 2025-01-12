package baseball.game;

import baseball.domain.number.BaseBallNumber;

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
            CompareResult result = compare(i, inputNumbers, resultNumbers);
            compareResult = compareResult.add(result);
        }

        return compareResult;
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
        return inputNumber.value() == resultNumber.value();
    }

    private boolean hasBall(final BaseBallNumber inputNumber, final List<BaseBallNumber> resultNumbers) {
        return resultNumbers.contains(inputNumber);
    }

    private void validateSameSize(final List<BaseBallNumber> inputNumbers, final List<BaseBallNumber> resultNumbers) {
        if (inputNumbers.size() != resultNumbers.size()) {
            throw new IllegalArgumentException("comparison lists must be have same size.");
        }
    }
}
