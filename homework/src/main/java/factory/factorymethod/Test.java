package factory.factorymethod;

import factory.factorymethod.factory.AliPaymentFactory;
import factory.factorymethod.factory.PaymentFactory;
import factory.factorymethod.factory.WechatPaymentFactory;
import factory.factorymethod.payment.IPayment;

import java.math.BigDecimal;

public class Test {
    /**
     * 工厂方法
     */
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new AliPaymentFactory();
        IPayment payment = paymentFactory.createPayment();
        payment.pay(new BigDecimal(2333.33));

        paymentFactory = new WechatPaymentFactory();
        payment = paymentFactory.createPayment();
        payment.pay(new BigDecimal(2333.33));
    }
}
