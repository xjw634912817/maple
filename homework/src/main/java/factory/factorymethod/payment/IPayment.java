package factory.factorymethod.payment;

import java.math.BigDecimal;

public interface IPayment {

    boolean pay(BigDecimal money);

}
