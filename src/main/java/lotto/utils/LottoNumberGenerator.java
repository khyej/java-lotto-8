package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    private static final int START = 1;
    private static final int END = 45;
    private static final int COUNT = 6;

    public List<Integer> generate(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START, END, COUNT);
        Collections.sort(numbers);
        return numbers;
    }
}
