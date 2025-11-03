package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoPrinter;
import lotto.model.LottoStats;
import lotto.model.PurchaseAmount;
import lotto.model.WinLotto;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoPrinter lottoPrinter;

    public LottoController(InputView inputView, OutputView outputView, LottoPrinter lottoPrinter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoPrinter = lottoPrinter;
    }

    public void run() {
        PurchaseAmount purchaseAmount = createPurchaseAmount();
        List<Lotto> lottos = lottoPrinter.print(purchaseAmount);

        outputView.displayLottoCount(purchaseAmount.getLottoCount());
        outputView.displayLottos(lottos);

        WinLotto winLotto = createWinLotto();

        LottoStats lottoStats = lottoPrinter.calculateStats(lottos, winLotto);
        double totalReturn = lottoStats.calculateTotalReturn(purchaseAmount);

        outputView.displayStats(lottoStats);
        outputView.displayTotalReturn(totalReturn);
    }

    private PurchaseAmount createPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.getPurchaseAmount();
                int amount = Validator.toInt(input, "[ERROR] 구입 금액은 숫자여야 합니다.");
                return new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    private WinLotto createWinLotto() {
        Lotto winNumbers = readWinNumbers();
        while (true) {
            try {
                int bonusNumber = readBonusNumber();
                return new WinLotto(winNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    private Lotto readWinNumbers() {
        while (true) {
            try {
                String input = inputView.getWinNumbers();
                String[] numbers = input.split(",");
                List<Integer> winNumbers = new ArrayList<>();
                for (String number : numbers) {
                    int winNumber = Validator.toInt(number.trim(), "[ERROR] 당첨 번호는 숫자여야 합니다.");
                    winNumbers.add(winNumber);
                }
                return new Lotto(winNumbers);
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }

    private int readBonusNumber() {
        while (true) {
            try {
                String input = inputView.getBonusNumber();
                return Validator.toInt(input, "[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                outputView.displayError(e.getMessage());
            }
        }
    }
}
