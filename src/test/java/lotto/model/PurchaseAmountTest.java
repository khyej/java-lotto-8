package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountTest {

    @ParameterizedTest
    @ValueSource(ints = { 0, -1000, 1500})
    void validatePurchaseAmountTest(int amount) {
        assertThatThrownBy(() -> new PurchaseAmount(amount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getLottoCountTest() {
        PurchaseAmount testLotto = new PurchaseAmount(1000);
        int testLottoCount = testLotto.getLottoCount();
        assertThat(testLottoCount).isEqualTo(1);
    }
}