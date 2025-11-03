package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {

    @Test
    @DisplayName("보너스 번호는 1~45 사이의 숫자여야 한다.")
    void numbersRangeTest() {
        assertThatThrownBy(() ->new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없다.")
    void numbersUniqueTest() {
        assertThatThrownBy(() ->new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 결과 테스트")
    void matchTest(){
        WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        LottoRank lottoRank = winLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }
}