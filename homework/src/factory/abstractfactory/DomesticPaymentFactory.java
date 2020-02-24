package factory.abstractfactory;

import factory.factorymethod.payment.IPayment;

public class DomesticPaymentFactory implements PaymentFactory {

    @Override
    public IPayment createPayment() {
        return null;
    }
}
