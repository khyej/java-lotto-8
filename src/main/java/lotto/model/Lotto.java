package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + COUNT + "개여야 합니다.");
        }
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
        for (int number : numbers) {
            if (number < START || number > END) {
                throw new IllegalArgumentException("로또 번호는 " + START + "~" + END + " 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
