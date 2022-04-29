package designpattern.structure.adapter.v3.adapters;

import designpattern.structure.adapter.ResultMsg;

public class LoginForTelAdapter extends AbstractAdapter {
    private String tel;

    public LoginForTelAdapter(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForTelAdapter;
    }

    @Override
    public ResultMsg processLogin(Object adapter) {
        if (!support(adapter)) {
            return new ResultMsg(500, "适配器错误", null);
        }
        return super.registerAndLogin(tel, null);
    }

}
