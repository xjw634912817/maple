package designpattern.creation.factorymethod.payment;

import java.math.BigDecimal;

public class WechatPayment implements IPayment {
    public boolean pay(BigDecimal money) {
        System.out.println("微信支付中：" + money);
        return true;
    }
}
