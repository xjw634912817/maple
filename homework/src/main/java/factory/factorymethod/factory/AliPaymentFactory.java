package factory.factorymethod.factory;

import factory.factorymethod.payment.AliPayment;
import factory.factorymethod.payment.IPayment;

public class AliPaymentFactory implements PaymentFactory {
    public IPayment createPayment() {
        return new AliPayment();
    }
}
