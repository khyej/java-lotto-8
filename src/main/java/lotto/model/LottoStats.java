package lotto.model;

import java.util.Map;

public class LottoStats {
    private final Map<LottoRank, Integer> lottoStats;

    public LottoStats(Map<LottoRank, Integer> lottoStats) {
        this.lottoStats = lottoStats;
    }

    public double calculateTotalReturn(PurchaseAmount purchaseAmount) {
        long totalPrizeMoney = getTotalPrizeMoney();
        int amount = purchaseAmount.getAmount();

        return (double) totalPrizeMoney / amount * 100.0;
    }

    private long getTotalPrizeMoney() {
        long totalPrizeMoney = 0;
        for (Map.Entry<LottoRank, Integer> entry : lottoStats.entrySet()) {
            totalPrizeMoney += (long) entry.getKey().getPrizeMoney() * entry.getValue();
        }
        return totalPrizeMoney;
    }

    public int getCount(LottoRank lottoRank) {
        return lottoStats.getOrDefault(lottoRank, 0);
    }
}
