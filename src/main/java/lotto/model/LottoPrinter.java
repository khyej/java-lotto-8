package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.LottoNumberGenerator;

public class LottoPrinter {
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoPrinter(LottoNumberGenerator lottoNumberGenerator){
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public List<Lotto> print(PurchaseAmount purchaseAmount){
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < purchaseAmount.getLottoCount(); i++){
            lottos.add(new Lotto(lottoNumberGenerator.generate()));
        }
        return lottos;
    }
}
