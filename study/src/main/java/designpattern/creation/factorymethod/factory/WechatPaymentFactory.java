package designpattern.creation.factorymethod.factory;


import designpattern.creation.factorymethod.payment.IPayment;
import designpattern.creation.factorymethod.payment.WechatPayment;

public class WechatPaymentFactory implements PaymentFactory {
    public IPayment createPayment() {
        return new WechatPayment();
    }
}
