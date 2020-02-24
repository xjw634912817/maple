package factory.abstractfactory;

import java.math.BigDecimal;

public class ApplePayment implements IForeignPay {
    @Override
    public boolean pay(BigDecimal money) {
        System.out.println("苹果支付");
        return true;
    }
}
