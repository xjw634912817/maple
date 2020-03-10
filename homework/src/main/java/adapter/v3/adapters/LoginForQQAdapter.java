package adapter.v3.adapters;

import adapter.ResultMsg;

public class LoginForQQAdapter extends AbstractAdapter {
    private String openId;

    public LoginForQQAdapter(String openId) {
        this.openId = openId;
    }

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public ResultMsg processLogin(Object adapter) {
        if (!support(adapter)) {
            return new ResultMsg(500, "适配器错误", null);
        }
        return super.registerAndLogin(this.openId, null);
    }
}
