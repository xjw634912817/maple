package designpattern.structure.adapter.v3.adapters;


import designpattern.structure.adapter.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);

    ResultMsg processLogin(Object adapter);
}
