package com.galip.BPN_challenge.Soru_4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AccountBalanceCalculator {
    public BigDecimal calculateAccountBalance(BigDecimal initialBalance, BigDecimal deposit, BigDecimal feePercentage) {
        BigDecimal newBalance = initialBalance.add(deposit);

        // burada divide metodunun 2. parametresi olan 2 değeri istenirse 3,4,5 gibi değerler de girilerek daha hassas hesaplama da yapılabilir
        // bu değer virgülden sonraki basamak sayısını gösterir.
        BigDecimal fee = newBalance.multiply(feePercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);

        return newBalance.subtract(fee);
    }
}
