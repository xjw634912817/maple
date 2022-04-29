package designpattern.structure.adapter.v3;


import designpattern.structure.adapter.ResultMsg;
import designpattern.structure.adapter.v3.adapters.AbstractAdapter;

public class PassportForThirdAdapt implements IPassportForThird {

    @Override
    public ResultMsg loginForThird(AbstractAdapter adapter) {
        return adapter.processLogin(adapter);
    }
}
