package lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.LottoNumberGenerator;

public class LottoPrinter {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPrinter(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> print(PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < purchaseAmount.getLottoCount(); i++) {
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }

    public LottoStats calculateStats(List<Lotto> lottos, WinLotto winLotto) {
        Map<LottoRank, Integer> lottoStats = new HashMap<>();

        for (Lotto lotto : lottos) {
            LottoRank rank = winLotto.match(lotto);
            int count = lottoStats.getOrDefault(rank, 0);
            lottoStats.put(rank, count + 1);
        }

        return new LottoStats(lottoStats);
    }
}
