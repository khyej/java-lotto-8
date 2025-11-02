package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoRankTest {
    @ParameterizedTest
    @CsvSource({
            "LOSE,0,false",
            "LOSE,1,false",
            "LOSE,2,false",
            "FIFTH,3,false",
            "FOURTH,4,false",
            "THIRD,5,false",
            "SECOND,5,true",
            "FIRST,6,false"
    })
    void lottoRankValueOfTest(LottoRank resultRank, int matchCount, boolean bonusNumber) {
        LottoRank testRank = LottoRank.valueOf(matchCount, bonusNumber);
        assertThat(testRank).isEqualTo(resultRank);
    }
}
