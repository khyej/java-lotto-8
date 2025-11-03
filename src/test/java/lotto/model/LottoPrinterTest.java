package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPrinterTest {
    @Test
    @DisplayName("로또 발행")
    void printTest() {
        LottoPrinter lottoPrinter = new LottoPrinter(new LottoNumberGenerator());
        assertDoesNotThrow(() -> lottoPrinter.print(new PurchaseAmount(1000)));
    }

    @Test
    @DisplayName("로또 당첨 결과")
    void calculateStatsTest() {
        LottoPrinter lottoPrinter = new LottoPrinter(new LottoNumberGenerator());

        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        LottoStats lottoStats = lottoPrinter.calculateStats(lottos, winLotto);
        assertThat(lottoStats.getCount(LottoRank.FIRST)).isEqualTo(1);
    }
}