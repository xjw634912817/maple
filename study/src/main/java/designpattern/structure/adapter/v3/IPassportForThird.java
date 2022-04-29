package designpattern.structure.adapter.v3;


import designpattern.structure.adapter.ResultMsg;
import designpattern.structure.adapter.v3.adapters.AbstractAdapter;

public interface IPassportForThird {
    ResultMsg loginForThird(AbstractAdapter adapter);
}
