package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    void numbersRangeTest() {
        assertThatThrownBy(() ->new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numbersUniqueTest() {
        assertThatThrownBy(() ->new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void matchTest(){
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoRank lottoRank = winLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}