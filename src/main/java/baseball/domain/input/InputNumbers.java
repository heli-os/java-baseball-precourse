package baseball.domain.input;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Heli
 * Created on 2022. 09. 28
 */
public class InputNumbers {

    private static final int INPUT_SIZE = 3;

    private final Set<StringAsPositiveInteger> numbers = new HashSet<>();

    public InputNumbers(final String input) {
        validateValueAsInteger(input);
        validateSize(input);

        for (char charAsInteger : input.toCharArray()) {
            numbers.add(new StringAsPositiveInteger(String.valueOf(charAsInteger)));
        }
    }

    public Iterator<StringAsPositiveInteger> numbers() {
        return numbers.iterator();
    }

    private void validateValueAsInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException("All elements of input must be Integer.", exception);
        }
    }

    private void validateSize(final String input) {
        if (INPUT_SIZE != input.length()) {
            throw new IllegalArgumentException(String.format("input.length() must be %s.", INPUT_SIZE));
        }
    }
}