package designpattern.creation.factorymethod.factory;


import designpattern.creation.factorymethod.payment.AliPayment;
import designpattern.creation.factorymethod.payment.IPayment;

public class AliPaymentFactory implements PaymentFactory {
    public IPayment createPayment() {
        return new AliPayment();
    }
}
