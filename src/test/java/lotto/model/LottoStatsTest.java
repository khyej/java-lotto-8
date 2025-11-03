package lotto.model;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStatsTest {
    @Test
    @DisplayName("로또 수익률 계산")
    void calculateTotalReturnTest() {
        Map<LottoRank, Integer> testStats = new HashMap<>();
        testStats.put(LottoRank.FIFTH, 1);
        LottoStats lottoStats = new LottoStats(testStats);

        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        double rate = lottoStats.calculateTotalReturn(purchaseAmount);

        assertThat(rate).isEqualTo(62.5);
    }

    @Test
    @DisplayName("로또 당첨 결과 통계")
    void getCountTest() {
        Map<LottoRank, Integer> testStats = new HashMap<>();
        testStats.put(LottoRank.FIFTH, 2);

        LottoStats lottoStats = new LottoStats(testStats);

        assertThat(lottoStats.getCount(LottoRank.FIFTH)).isEqualTo(2);
    }
}