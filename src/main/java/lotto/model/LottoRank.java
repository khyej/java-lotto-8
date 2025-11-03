package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    LOSE(0, 0, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusNumber;

    private final String description;

    LottoRank(int matchCount, int prizeMoney, boolean bonusNumber) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusNumber = bonusNumber;
        this.description = formatDescription(matchCount, prizeMoney);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank valueOf(int matchCount, boolean bonusNumber) {
        if (matchCount == 5 && bonusNumber) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && !rank.bonusNumber)
                .findFirst()
                .orElse(LOSE);
    }

    private String formatDescription(int matchCount, int prizeMoney) {
        if (this == LOSE) {
            return "";
        }
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matchCount, prizeMoney);
        }
        return String.format("%d개 일치 (%,d원)", matchCount, prizeMoney);
    }
}
