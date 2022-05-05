package designpattern.creation.factorymethod;


import designpattern.creation.factorymethod.factory.AliPaymentFactory;
import designpattern.creation.factorymethod.factory.PaymentFactory;
import designpattern.creation.factorymethod.factory.WechatPaymentFactory;
import designpattern.creation.factorymethod.payment.IPayment;

import java.math.BigDecimal;

public class Test {
    /**
     * 工厂方法
     */
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new AliPaymentFactory();
        IPayment payment = paymentFactory.createPayment();
        payment.pay(new BigDecimal("2333.33"));

        paymentFactory = new WechatPaymentFactory();
        payment = paymentFactory.createPayment();
        payment.pay(new BigDecimal("2333.33"));
    }
}
