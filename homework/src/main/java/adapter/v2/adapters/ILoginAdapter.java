package adapter.v2.adapters;

import adapter.ResultMsg;

public interface ILoginAdapter {
    boolean support(Object object);

    ResultMsg processLogin(String id, Object adapter);
}
