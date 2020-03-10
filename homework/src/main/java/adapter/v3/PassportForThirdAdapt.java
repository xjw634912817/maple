package adapter.v3;

import adapter.ResultMsg;
import adapter.v3.adapters.AbstractAdapter;

public class PassportForThirdAdapt implements IPassportForThird {

    @Override
    public ResultMsg loginForThird(AbstractAdapter adapter) {
        return adapter.processLogin(adapter);
    }
}
