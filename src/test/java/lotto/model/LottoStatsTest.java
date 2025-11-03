package lotto.model;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class LottoStatsTest {

    @Test
    void calculateTotalReturnTest() {
        Map<LottoRank, Integer> testStats = new HashMap<>();
        testStats.put(LottoRank.FIFTH, 1);
        LottoStats lottoStats = new LottoStats(testStats);

        PurchaseAmount purchaseAmount = new PurchaseAmount(8000);

        double rate = lottoStats.calculateTotalReturn(purchaseAmount);

        assertThat(rate).isEqualTo(62.5);
    }

    @Test
    void getCountTest() {
        Map<LottoRank, Integer> testStats = new HashMap<>();
        testStats.put(LottoRank.FIFTH, 2);

        LottoStats lottoStats = new LottoStats(testStats);

        assertThat(lottoStats.getCount(LottoRank.FIFTH)).isEqualTo(2);
    }
}