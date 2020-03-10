package adapter.v2.adapters;

import adapter.ResultMsg;

public class LoginForWechatAdapter extends AbstractAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWechatAdapter;
    }

    @Override
    public ResultMsg processLogin(String id, Object adapter) {
        if (!support(adapter)) {
            return new ResultMsg(500, "适配器错误", null);
        }
        return super.registerAndLogin(id, null);
    }

}
