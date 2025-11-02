package lotto.model;

import java.util.List;

public class WinLotto {
    private final Lotto winLotto;
    private final int bonusNumber;

    public WinLotto(Lotto winLotto, int bonusNumber) {
        validateBonusNumber(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank match(Lotto lotto) {
        int matchCount = countMatchNumbers(lotto);
        boolean matchBonus = lotto.getNumbers().contains(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    private void validateBonusNumber(Lotto winLotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자여야 합니다.");
        }

        if (winLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    private int countMatchNumbers(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        return (int) lottoNumbers.stream()
                .filter(number -> winLotto.getNumbers().contains(number))
                .count();
    }
}
