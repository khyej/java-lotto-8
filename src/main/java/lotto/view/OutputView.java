package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void displayLottoCount(int count){
        System.out.println(count+ "개를 구매했습니다.");
    }

    public void displayLottos(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }
}
