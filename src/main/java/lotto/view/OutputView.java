package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoStats;

public class OutputView {
    private static final List<LottoRank> DISPLAY_RANK = List.of(
            LottoRank.FIFTH, LottoRank.FOURTH, LottoRank.THIRD, LottoRank.SECOND, LottoRank.FIRST
    );

    public void displayLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void displayStats(LottoStats lottoStats) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (LottoRank lottoRank : DISPLAY_RANK) {
            System.out.printf("%s - %d개",
                    lottoRank.getDescription(),
                    lottoStats.getCount(lottoRank)
            );
            System.out.println();
        }
    }

    public void displayTotalReturn(double totalReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalReturn);
    }

    public void displayError(String message) {
        System.out.println("[ERROR] " + message);
    }
}
