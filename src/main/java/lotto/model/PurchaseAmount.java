package lotto.model;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount){
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount){
        if(amount <= 0 || amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위로 입력해주세요.");
        }
    }

    public int getLottoCount(){
        return amount / 1000;
    }
}
