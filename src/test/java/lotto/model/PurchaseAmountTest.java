package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @DisplayName("로또 구입 금액은 1000원 단위의 숫자여야 한다.")
    @ValueSource(ints = { 0, -1000, 1500})
    void validatePurchaseAmountTest(int amount) {
        assertThatThrownBy(() -> new PurchaseAmount(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 한 장의 가격은 1000원이다.")
    void getLottoCountTest() {
        PurchaseAmount testLotto = new PurchaseAmount(1000);
        int testLottoCount = testLotto.getLottoCount();
        assertThat(testLottoCount).isEqualTo(1);
    }
}