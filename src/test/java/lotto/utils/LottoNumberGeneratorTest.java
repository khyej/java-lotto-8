package lotto.utils;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoNumberGeneratorTest {
    @Test
    void generateTest() {
        LottoNumberGenerator test = new LottoNumberGenerator();
        List<Integer> result = test.generate();
        assertDoesNotThrow(() -> new Lotto(result));
    }

    @Test
    void generateSortNumber(){
        LottoNumberGenerator test = new LottoNumberGenerator();
        List<Integer> result = test.generate();
        assertThat(result).isSorted();
    }
}