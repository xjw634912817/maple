package factory.factorymethod.factory;

import factory.factorymethod.payment.IPayment;

public interface PaymentFactory {

    IPayment createPayment();

}
