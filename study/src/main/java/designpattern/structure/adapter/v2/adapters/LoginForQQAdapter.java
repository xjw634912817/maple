package designpattern.structure.adapter.v2.adapters;

import designpattern.structure.adapter.ResultMsg;

public class LoginForQQAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg processLogin(String id, Object adapter) {
        if (!support(adapter)) {
            return new ResultMsg(500, "适配器错误", null);
        }
        return super.registerAndLogin(id, null);
    }
}
