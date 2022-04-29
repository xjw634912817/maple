package designpattern.creation.factorymethod.factory;


import designpattern.creation.factorymethod.payment.IPayment;

public interface PaymentFactory {

    IPayment createPayment();

}
