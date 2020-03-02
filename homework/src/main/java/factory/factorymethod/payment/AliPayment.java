package factory.factorymethod.payment;

import java.math.BigDecimal;

public class AliPayment implements IPayment {
    public boolean pay(BigDecimal money) {
        System.out.println("阿里支付中：" + money);
        return true;
    }
}
