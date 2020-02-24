package factory.abstractfactory;

import java.math.BigDecimal;

public class AliPayment implements IDomesticPay {
    @Override
    public boolean pay(BigDecimal money) {
        System.out.println("阿里支付");
        return true;
    }
}
