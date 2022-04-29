package designpattern.structure.adapter.v3.adapters;

import designpattern.structure.adapter.ResultMsg;

public class LoginForTokenAdapter extends AbstractAdapter {

    private String token;

    public LoginForTokenAdapter(String token) {
        this.token = token;
    }

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTokenAdapter;
    }

    @Override
    public ResultMsg processLogin(Object adapter) {
        if (!support(adapter)) {
            return new ResultMsg(500, "适配器错误", null);
        }
        return super.registerAndLogin(token, null);
    }

}
