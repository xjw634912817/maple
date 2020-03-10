package adapter.v3.adapters;

import adapter.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);

    ResultMsg processLogin(Object adapter);
}
