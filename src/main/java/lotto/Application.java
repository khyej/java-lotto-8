package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.model.LottoPrinter;
import lotto.utils.LottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try{
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            LottoPrinter lottoPrinter = new LottoPrinter(lottoNumberGenerator);

            LottoController lottoController = new LottoController(inputView, outputView, lottoPrinter);
            lottoController.run();
        } finally {
            Console.close();
        }
    }
}
