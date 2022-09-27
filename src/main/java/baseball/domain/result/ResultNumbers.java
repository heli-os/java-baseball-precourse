package baseball.domain.result;

import baseball.game.BaseBallNumber;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class ResultNumbers {

    private final Set<ResultNumber> numbers = new HashSet<>();

    public ResultNumbers(final int totalSize, final int startInclusive, final int endInclusive) {
        validateRange(totalSize, startInclusive, endInclusive);
        while (numbers.size() < totalSize) {
            int pickedNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            ResultNumber resultNumber = new ResultNumber(pickedNumber);
            numbers.add(resultNumber);
        }
    }

    public List<BaseBallNumber> numbers() {
        return new ArrayList<>(numbers);
    }

    private void validateRange(final int totalSize, final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (totalSize > endInclusive - startInclusive + 1) {
            throw new IllegalArgumentException("totalSize cannot be greater than rangeSize(endInclusive - startInclusive + 1)");
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
