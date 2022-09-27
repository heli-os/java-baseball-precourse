package baseball.domain.result;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heli
 * Created on 2022. 09. 27
 */
public class ResultNumbers {

    private final Set<ResultNumber> numbers = new HashSet<>();
    private final MetaData metaData;

    public ResultNumbers(final int totalSize, final int startInclusive, final int endInclusive) {
        validateRange(totalSize, startInclusive, endInclusive);
        while (numbers.size() < totalSize) {
            int pickedNumber = Randoms.pickNumberInRange(startInclusive, endInclusive);
            ResultNumber resultNumber = new ResultNumber(pickedNumber);
            numbers.add(resultNumber);
        }
        this.metaData = new MetaData(totalSize, startInclusive, endInclusive);
    }

    public MetaData metaData() {
        return metaData;
    }

    private void validateRange(final int totalSize, final int startInclusive, final int endInclusive) {
        if (startInclusive > endInclusive) {
            throw new IllegalArgumentException("startInclusive cannot be greater than endInclusive.");
        }
        if (totalSize > endInclusive - startInclusive + 1) {
            throw new IllegalArgumentException("totalSize cannot be greater than rangeSize(endInclusive - startInclusive + 1)");
        }
    }

    public static class MetaData {
        private final int totalSize;
        private final int startInclusive;
        private final int endInclusive;

        private MetaData(final int totalSize, final int startInclusive, final int endInclusive) {
            this.totalSize = totalSize;
            this.startInclusive = startInclusive;
            this.endInclusive = endInclusive;
        }

        public int totalSize() {
            return totalSize;
        }

        public int startInclusive() {
            return startInclusive;
        }

        public int endInclusive() {
            return endInclusive;
        }
    }
}
