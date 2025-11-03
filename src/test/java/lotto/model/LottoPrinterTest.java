package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import lotto.utils.LottoNumberGenerator;
import org.junit.jupiter.api.Test;

class LottoPrinterTest {
    @Test
    void printTest() {
        LottoPrinter lottoPrinter = new LottoPrinter(new LottoNumberGenerator());
        assertDoesNotThrow(() -> lottoPrinter.print(new PurchaseAmount(1000)));
    }
}