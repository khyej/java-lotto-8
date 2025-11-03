package lotto.utils;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호 랜덤 생성 테스트")
    void generateTest() {
        LottoNumberGenerator test = new LottoNumberGenerator();
        List<Integer> result = test.generate();
        assertDoesNotThrow(() -> new Lotto(result));
    }

    @Test
    @DisplayName("로또 번호 정렬 테스트")
    void generateSortNumber() {
        LottoNumberGenerator test = new LottoNumberGenerator();
        List<Integer> result = test.generate();
        assertThat(result).isSorted();
    }
}