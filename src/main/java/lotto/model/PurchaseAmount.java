package lotto.model;

public class PurchaseAmount {
    private static final int AMOUNT_UNIT = 1000;

    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getLottoCount() {
        return amount / AMOUNT_UNIT;
    }

    private void validate(int amount) {
        if (amount <= 0 || amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("구입 금액은 " + AMOUNT_UNIT + "원 단위로 입력해주세요.");
        }
    }
}
