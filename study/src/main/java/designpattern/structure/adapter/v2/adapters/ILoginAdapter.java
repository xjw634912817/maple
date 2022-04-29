package designpattern.structure.adapter.v2.adapters;

import designpattern.structure.adapter.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);

    ResultMsg processLogin(String id, Object adapter);
}
