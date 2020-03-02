package factory.factorymethod.factory;

import factory.factorymethod.payment.IPayment;
import factory.factorymethod.payment.WechatPayment;

public class WechatPaymentFactory implements PaymentFactory {
    public IPayment createPayment() {
        return new WechatPayment();
    }
}
